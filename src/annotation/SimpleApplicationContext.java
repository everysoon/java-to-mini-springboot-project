package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/*
    리플랙션 : 자바 런타임중에 클래스,메서드,필드, 생성자 등의 정보를 조회하고 조작할 수 있는 기능
    ㄴ "자바 코드를 실행하면서 클래스 구조를 들여다보고, 필요하면 바꿀 수도 있는 능력" (일반코드와는 다르게 컴파일이 아닌 런타임에 조작 가능)
    1) 동적 클래스 로딩 가능
    2) 메서드 호출 가능
    3) 필드 접근 가능
    4) 어노테이션 정보 읽기
**/
public class SimpleApplicationContext {
    private Map<String, Object> beans = new HashMap<>();

    public SimpleApplicationContext(Class<?>... Classes) {
        try {
            for (Class<?> clazz : Classes) {
                if (clazz.isAnnotationPresent(Component.class)) {
                    Component component = clazz.getAnnotation(Component.class);
                    String beanName = component.value().isEmpty() ? clazz.getSimpleName() : component.value();
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    beans.put(beanName, instance);
                }
                if (clazz.isAnnotationPresent(Configuration.class)) {
                    Object configInstance = clazz.getDeclaredConstructor().newInstance();
                    for (Method method : clazz.getDeclaredMethods()) { // 메서드 정보 가져오기
                        Bean beanAnnotation = method.getAnnotation(Bean.class);
                        String beanName = beanAnnotation.value().isEmpty() ? method.getName() : beanAnnotation.value();
                        Object bean = method.invoke(configInstance); // 런타임에 메서드를 실행해서 실제 Bean 객체를 반환
                        beans.put(beanName, bean);
                    }
                }
            }
            for (Object bean : beans.values()) {
                injectDependencies(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void injectDependencies(Object bean) throws IllegalAccessException {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Object dependency = getBean(field.getType()); // 해당 타입 빈을 찾음
                field.setAccessible(true); // private 필드에도 접근 허용 true
                field.set(bean, dependency); // bean 인스턴스의 해당 필드에 dependency 주입 (리플렉션을 이용해 필드 값 주입)
            }
        }
    }

    // Bean 가져오기
    public Object getBean(String name) {
        return beans.get(name);
    }

    public <T> T getBean(Class<T> type) {
        return type.cast(
                beans.values().stream()
                        .filter(type::isInstance)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("No bean found"))
        );
    }
}

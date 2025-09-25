package main.annotation.test.component;

import main.annotation.SimpleApplicationContext;

public class ComponentTest {
    public static void main(String[] args) {
//        Class<?> clazz = MyService.class;
//        if(clazz.isAnnotationPresent(Component.class)){
//            Component comp = clazz.getAnnotation(Component.class);
//            System.out.println("Component value : "+ comp.value());
//        }
        SimpleApplicationContext context = new SimpleApplicationContext(MyService.class);
        MyService myService = context.getBean(MyService.class);
        myService.hello();
    }
}

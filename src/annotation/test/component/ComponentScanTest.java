package annotation.test.component;

import annotation.ComponentScan;
import annotation.SimpleApplicationContext;
import annotation.test.autowired.UserRepository;

public class ComponentScanTest {
    @ComponentScan(basePackage = "annotation")
    public static class InnerConfig{

    }
    public static void main(String[] args) {
        SimpleApplicationContext context = new SimpleApplicationContext(InnerConfig.class, UserRepository.class,MyService.class);
        MyService myService = context.getBean(MyService.class);
        myService.hello();
    }
}

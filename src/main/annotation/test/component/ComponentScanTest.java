package main.annotation.test.component;

import main.annotation.ComponentScan;
import main.annotation.SimpleApplicationContext;
import main.annotation.test.autowired.UserRepository;

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

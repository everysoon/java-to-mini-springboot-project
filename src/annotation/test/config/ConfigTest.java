package annotation.test.config;

import annotation.SimpleApplicationContext;
import annotation.test.component.MyService;

public class ConfigTest {
    public static void main(String[] args) {
        SimpleApplicationContext context = new SimpleApplicationContext(AppConfig.class);
        MyService service = context.getBean(MyService.class);
        service.hello();
    }
}

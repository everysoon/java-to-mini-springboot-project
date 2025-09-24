package annotation.test.autowired;

import annotation.SimpleApplicationContext;
import annotation.test.component.MyService;

public class AutowiredTest {
    public static void main(String[] args) {
        SimpleApplicationContext context = new SimpleApplicationContext(UserRepository.class, UserService.class);
        UserService userService = context.getBean(UserService.class);
        userService.printUserName();
    }
}

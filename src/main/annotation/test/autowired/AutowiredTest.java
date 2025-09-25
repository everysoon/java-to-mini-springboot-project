package main.annotation.test.autowired;

import main.annotation.SimpleApplicationContext;

public class AutowiredTest {
    public static void main(String[] args) {
        SimpleApplicationContext context = new SimpleApplicationContext(UserRepository.class, UserService.class);
        UserService userService = context.getBean(UserService.class);
        userService.printUserName();
    }
}

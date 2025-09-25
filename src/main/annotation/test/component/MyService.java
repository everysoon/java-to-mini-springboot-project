package main.annotation.test.component;

import main.annotation.Autowired;
import main.annotation.Component;
import main.annotation.test.autowired.UserRepository;

@Component
public class MyService {
    @Autowired
    private UserRepository userRepository;

    public void hello() {
        System.out.println("Hello " + userRepository.findUserName());
    }
}

package annotation.test.component;

import annotation.Autowired;
import annotation.Component;
import annotation.test.autowired.UserRepository;

@Component
public class MyService {
    @Autowired
    private UserRepository userRepository;

    public void hello() {
        System.out.println("Hello " + userRepository.findUserName());
    }
}

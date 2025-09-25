package main.annotation.test.autowired;

import main.annotation.Autowired;
import main.annotation.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void printUserName(){
        System.out.println(userRepository.findUserName());
    }
}

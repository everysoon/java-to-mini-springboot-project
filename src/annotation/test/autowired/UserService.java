package annotation.test.autowired;

import annotation.Autowired;
import annotation.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void printUserName(){
        System.out.println(userRepository.findUserName());
    }
}

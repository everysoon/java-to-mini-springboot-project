package annotation.test.autowired;

import annotation.Component;

@Component
public class UserRepository {
    public String findUserName(){
        return "민선";
    }
}

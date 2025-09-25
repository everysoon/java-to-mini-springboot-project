package main.annotation.test.autowired;

import main.annotation.Component;

@Component
public class UserRepository {
    public String findUserName(){
        return "민선";
    }
}

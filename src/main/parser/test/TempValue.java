package main.parser.test;

import main.parser.Value;

public class TempValue {
    @Value("${people.name}")
    private String name;

    public String getName() {
        return name;
    }
}

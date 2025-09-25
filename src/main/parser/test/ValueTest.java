package main.parser.test;

import main.parser.PropertiesFilePropertySource;
import main.parser.ValueInjector;
import main.parser.YmlPropertySource;

public class ValueTest {

    public static void main(String[] args) {
//        PropertiesFilePropertySource propertySource = new PropertiesFilePropertySource("application.properties");
        YmlPropertySource ymlPropertySource = new YmlPropertySource("application.yml");
        ValueInjector valueInjector = new ValueInjector(ymlPropertySource);
        TempValue tempValue = new TempValue();
        valueInjector.inject(tempValue);
        System.out.println(tempValue.getName());
    }
}

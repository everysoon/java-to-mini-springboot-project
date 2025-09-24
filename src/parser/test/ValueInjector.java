package parser.test;

import parser.PropertySource;
import parser.Value;
import utils.Converters;

import java.lang.reflect.Field;

public class ValueInjector {
    private final PropertySource propertySource;
    public ValueInjector(PropertySource propertySource) {
        this.propertySource = propertySource;
    }
    public void inject(Object target) {
        for(Field field : target.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Value.class)){
                Value annotation = field.getAnnotation(Value.class);
                String key = annotation.value()  .replace("${", "").replace("}", "");
                String value = propertySource.get(key);
                if (value == null) continue;
                field.setAccessible(true); // private 필드라도 접근가능하게 설정!
                try{
                    Object converted = Converters.convert(value, field.getType());
                    field.set(target,converted);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

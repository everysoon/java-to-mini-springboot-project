package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)       // 붙일 수 있는 위치 (TYPE, METHOD, FIELD, PARAMETER 등)
@Retention(RetentionPolicy.RUNTIME) // 실행 중에도 읽을 수 있게 (ex. source- 컴파일 후 버려짐,class-클래스 파일까지만 남고 실행중엔 못읽음)
public @interface Component {
    String value() default "";
}

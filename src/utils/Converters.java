package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converters {
    public interface Converter<T> {
        Object convert(String value);
    }
    /**
     * 키 : 변환할 대상 타입 (int,Long,Boolean..)
     * 값 : 해당 타입으로 변환해주는 함수(Converter)
     * */
    private static final Map<Class<?>, Converter<?>> converters = new HashMap<>();
    //  정적 블록 : 클래스가 처음 로딩될 때 한 번만 실행
    static {
        converters.put(int.class, Integer::parseInt);
        converters.put(Integer.class, Integer::parseInt);

        converters.put(long.class, Long::parseLong);
        converters.put(Long.class, Long::parseLong);

        converters.put(boolean.class, Boolean::parseBoolean);
        converters.put(Boolean.class, Boolean::parseBoolean);

        converters.put(double.class, Double::parseDouble);
        converters.put(Double.class, Double::parseDouble);

        converters.put(String.class, v -> v); // 문자열은 그대로!
    }

    @SuppressWarnings("unchecked")
    public static <T> T convert(String value, Class<T> targetType) {
        Converter<?> converter = converters.get(targetType);
        // ✅ Enum 처리
        if (targetType.isEnum()) {
            return (T) Enum.valueOf((Class<Enum>) targetType.asSubclass(Enum.class), value);
        }

        // ✅ List<T> 처리 (예: "1,2,3" → List<Integer>)
        if (List.class.isAssignableFrom(targetType)) {
            throw new IllegalArgumentException("List 변환은 convertList()를 사용하세요!");
        }
        if (converter == null) {
            throw new IllegalArgumentException("No converter for type: " + targetType);
        }
        return (T) converter.convert(value);
    }

    /**
     * 콤마(,) 구분 문자열을 리스트로 변환
     * 예: "1,2,3" → List<Integer>
     */
    public static <T> List<T> convertList(String value, Class<T> elementType) {
        String[] parts = value.split(",");
        return Arrays.stream(parts)
                .map(String::trim)
                .map(v -> convert(v, elementType))
                .collect(Collectors.toList());
    }
}

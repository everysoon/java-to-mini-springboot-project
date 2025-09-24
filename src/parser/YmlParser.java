package parser;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
// implementation 'org.yaml:snakeyaml:2.0' 사용

/**
 * 순수 자바 프로젝트에 gradle 이용하기
 * 1) gradle init
 * 2) application (main 메서드 실행 가능), basic
 */
public class YmlParser {
    private Map<String, Object> ymlMap;

    public YmlParser(String filePath) {
        Yaml yaml = new Yaml();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            ymlMap = yaml.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // "spring.application.name" 같은 .으로 구분된 경로를 탐색
    public Object get(String key) {
        String[] keys = key.split("\\."); // 정규식에서 \\. 의 의미는 Java문자열에서 이스케이프 \ + 정규식에서 이스케이프 \ + .
        Map<String, Object> map = ymlMap;
        Object value = null;
        for (String k : keys) {
            value = map.get(k);
            if(value instanceof Map){
                map = (Map<String, Object>) value;
            }else{
                break;
            }
        }
        return value;
    }
}

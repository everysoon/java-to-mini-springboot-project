package parser;

public class YmlPropertySource implements PropertySource {
    private final YmlParser ymlParser;
    public YmlPropertySource(String path) {
        this.ymlParser = new YmlParser(path);
    }
    @Override
    public String get(String key) {
        return this.ymlParser.get(key).toString();
    }
}

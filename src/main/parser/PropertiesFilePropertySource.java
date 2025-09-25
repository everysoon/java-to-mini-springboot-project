package main.parser;

public class PropertiesFilePropertySource implements PropertySource {
    private final PropertiesParser propertiesParser;

    public PropertiesFilePropertySource(String path) {
        this.propertiesParser = new PropertiesParser(path);
    }

    @Override
    public String get(String key) {
        return this.propertiesParser.get(key);
    }
}

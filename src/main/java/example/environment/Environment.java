package example.environment;

import java.util.HashMap;
import java.util.Map;

enum Environment {
    INSTANCE();

    private Map<String, String> map;

    Environment() {
        this.map = new HashMap<>(System.getenv());
    }

    String set(String key, String value) {
        return map.put(key, value);
    }

    String get(String key) {
        return map.get(key);
    }

}

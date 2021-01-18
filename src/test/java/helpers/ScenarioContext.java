package helpers;

import enums.Context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<Context, String> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(Context key, String value) {
        scenarioContext.put(key, value);
    }

    public String getContext(Context key){
        return scenarioContext.get(key);
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key);
    }
}

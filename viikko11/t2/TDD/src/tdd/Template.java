package tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template {
    private Map<String, String> values;
    private String template;

    public Template(String template) {
        this.template = template;
        values = new HashMap<String, String>();
    }

    public void korvaa(String changeFromValue, String changeToValue) {
        values.put(changeFromValue, changeToValue);
    }

    public String evaluoi() {
        String result = template;
        for(Map.Entry<String, String> pair : values.entrySet()) {
            String replacable = "\\$\\{" + pair.getKey() + "\\}";
            result = result.replaceAll(replacable, pair.getValue());
        }
        checkMissing(result);
        return result;
    }

    private void checkMissing(String msg) {
        Matcher m = Pattern.compile("\\$\\{.+\\}").matcher(msg);
        if(m.find()) throw new PuuttuvaArvoException("Muuttujalla " + m.group() + " ei ole arvoa.");
    }
}

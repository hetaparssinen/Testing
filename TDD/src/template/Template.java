package template;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template {
    private Map<String, String> values;
    private String template;

    public Template(String template) {
        this.template = template;
        values = new HashMap<String, String>();
    }

    public void korvaa(String val, String replace) {
        values.put(val, replace);
    }

    public String evaluoi() {
        String result = template;
        for(Map.Entry<String, String> pair : values.entrySet()) {
            String replace = "\\$\\{" + pair.getKey() + "\\}";
            result = result.replaceAll(replace, pair.getValue());
        }
        checkMissing(result); 
        return result;
    }
    
    private void checkMissing(String text) {
        Matcher m = Pattern.compile("\\$\\{.+\\}").matcher(text);
        if (m.find()){
            throw new PuuttuvaArvoException("Muuttujalla " + m.group()
            + " ei ole arvoa.");
        } 
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Heta
 */
public class Tdd {
    private Map<String, String> values;
    private String template;

    public Tdd(String template) {
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

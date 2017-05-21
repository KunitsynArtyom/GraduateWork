package diploma.logic.parsers.entities.function;

import diploma.logic.parsers.entities.QueryAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Артём on 15.05.2017.
 */
public class FunctionHeader {

    public List<QueryAttribute> getAttributes(String functionHeader) {
        String regex = "(\\w+)\\s+\\w+\\,?\\s*";
        List<QueryAttribute> functionHeaderAttributes = new ArrayList<QueryAttribute>();

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(functionHeader);
            while (matcher.find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    functionHeaderAttributes.add(new QueryAttribute(matcher.group(i)));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return functionHeaderAttributes;
    }
}

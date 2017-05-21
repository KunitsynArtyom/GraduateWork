package parser;

import diploma.logic.parsers.entities.QueryAttribute;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Артём on 15.05.2017.
 */
public class RegexTest {

    @Test
    public void checkRegex() {
        String query = "BEGIN \n" +
                "CREATE FUNCTION check_password(uname TEXT, pass TEXT) \n" +
                "SELECT qwerty FROM qwerty; UPDATE qwerty1 FROM qwerty1;";

        String regex1 = "CREATE FUNCTION\\s+\\w+\\(((\\w+\\s+\\w+\\,?\\s*)*)\\)";

        String str1 = parseFunctionHeader(query, regex1);
        System.out.println("str1" + str1);
        System.out.println(getAttributes(str1));
    }

    private String parseFunctionHeader(String sqlFunction, String functionHeaderRegex) {
        String functionHeader = "";

        System.out.println(sqlFunction);
        Pattern pattern = Pattern.compile(functionHeaderRegex);
        Matcher matcher = pattern.matcher(sqlFunction);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            functionHeader = matcher.group(1);
        }

        return functionHeader;
    }

    public List<QueryAttribute> getAttributes(String functionHeader) {
        System.out.println(functionHeader);
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

        for(QueryAttribute queryAttribute : functionHeaderAttributes){
            System.out.println("attribute: " + queryAttribute.toString());
        }

        return functionHeaderAttributes;
    }
}

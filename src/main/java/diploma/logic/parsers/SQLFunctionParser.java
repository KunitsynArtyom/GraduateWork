package diploma.logic.parsers;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Артём on 05.05.2017.
 */
public class SQLFunctionParser {

    private Logger logger = Logger.getLogger(SQLFunctionParser.class);

    private final String regex = "(?i)(select|update|insert|delete).+(?=;)";
    private String sqlFunctionText;

    public SQLFunctionParser(String sqlFunctionText) {
        this.sqlFunctionText = sqlFunctionText;
    }

    public List<String> parseSQLFunction() {
        List<String> sqlQueryList = new ArrayList<>();
        sqlQueryList.addAll(parse(sqlFunctionText));
        return sqlQueryList;
    }

    private List<String> parse(String query) {
        List<String> sqlQueryList = new ArrayList<>();
        try {
            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(query);
            while (matcher.find()) {
                sqlQueryList.addAll(Arrays.asList(matcher.group(0).split(";")));
            }
        } catch (Exception e) {
            logger.debug("Errors while parsing");
        }

        return sqlQueryList;
    }
}

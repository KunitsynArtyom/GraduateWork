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

    private final String queryRegex = "(?i)(select|update|insert|delete).+(?=;)";
    private final String functionHeaderRegex = "CREATE FUNCTION\\s+\\w+\\(((\\w+\\s+\\w+\\,?\\s*)*)\\)";
    private final String returnStatementRegex = "(?i)return\\s(.+(?=;))";
    private String sqlFunctionText;

    public SQLFunctionParser(String sqlFunctionText) {
        this.sqlFunctionText = sqlFunctionText;
    }

    public List<String> parseSQLFunction() {
        List<String> sqlQueryList = new ArrayList<>();
        sqlQueryList.addAll(parse(sqlFunctionText));
        return sqlQueryList;
    }

    private List<String> parse(String sqlFunction) {
        List<String> sqlLexList = new ArrayList<String>();

        sqlLexList.add(parseFunctionHeader(sqlFunction));
        sqlLexList.addAll(parseSQLQueries(sqlFunction));
        sqlLexList.addAll(parseReturnStatement(sqlFunction));

        return sqlLexList;
    }

    private String parseFunctionHeader(String sqlFunction) {
        String functionHeader = "";

        try {
            Pattern pattern = Pattern.compile(functionHeaderRegex);
            Matcher matcher = pattern.matcher(sqlFunction);
            while (matcher.find()) {
                functionHeader = matcher.group(1);
            }
        } catch (Exception e) {
            System.out.println("Errors while parsing");
            logger.debug("Errors while parsing");
        }

        return functionHeader;
    }

    private List<String> parseSQLQueries(String sqlFunction) {
        List<String> sqlQueryList = new ArrayList<String>();

        try {
            Pattern pattern = Pattern.compile(queryRegex);
            Matcher matcher = pattern.matcher(sqlFunction);
            while (matcher.find()) {
                sqlQueryList.addAll(Arrays.asList(matcher.group(0).split(";")));
            }
        } catch (Exception e) {
            System.out.println("Errors while parsing");
            logger.debug("Errors while parsing");
        }

        return sqlQueryList;
    }

    private List<String> parseReturnStatement(String sqlFunction){
        List<String> returnStatementList = new ArrayList<String>();

        try{
            Pattern pattern = Pattern.compile(returnStatementRegex);
            Matcher matcher = pattern.matcher(sqlFunction);
            while (matcher.find()) {
                returnStatementList.addAll(Arrays.asList(matcher.group(0)));
            }
        } catch (Exception e) {
            System.out.println("Errors while parsing");
            logger.debug("Errors while parsing");
        }

        return returnStatementList;
    }
}

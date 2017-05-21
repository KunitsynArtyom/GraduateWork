package diploma.logic.parsers;

import diploma.logic.graphs.prodsys.entities.Implication;
import diploma.logic.parsers.entities.QueryAttribute;
import diploma.logic.parsers.entities.function.FunctionHeader;
import diploma.logic.parsers.entities.function.ReturnStatement;
import diploma.logic.parsers.entities.queries.InsertQuery;
import diploma.logic.parsers.entities.queries.Query;
import diploma.logic.parsers.entities.queries.SelectQuery;
import diploma.logic.parsers.entities.queries.UpdateQuery;
import net.sf.jsqlparser.JSQLParserException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артём on 01.04.2017.
 */
public class SQLParser {

    private Logger logger = Logger.getLogger(SQLParser.class);

    private List<String> sqlLexList;
    private List<QueryAttribute> outerAttributes;
    private List<QueryAttribute> innerAttributes;
    private List<QueryAttribute> outerResults;
    private List<QueryAttribute> innerResults;

    public SQLParser(List<String> sqlLexList) {
        this.sqlLexList = sqlLexList;
        this.outerAttributes = new ArrayList<QueryAttribute>();
        this.innerAttributes = new ArrayList<QueryAttribute>();
        this.outerResults = new ArrayList<QueryAttribute>();
        this.innerResults = new ArrayList<QueryAttribute>();
    }

    public Implication<QueryAttribute> getImplication() {

        for(String str : sqlLexList){
            System.out.println(str);
        }

        try {

            for (String sqlLex : sqlLexList) {
                if (sqlLex.toLowerCase().contains("select")) {
                    innerAttributes.addAll(getInnerArguments(new SelectQuery(), sqlLex));
                } else if (sqlLex.toLowerCase().contains("insert")) {
                    innerResults.addAll(getInnerResults(new InsertQuery(), sqlLex));
                } else if (sqlLex.toLowerCase().contains("update")) {
                    innerResults.addAll(getInnerResults(new UpdateQuery(), sqlLex));
                } else if (sqlLex.toLowerCase().contains("return")){
                    outerResults.addAll(new ReturnStatement().getAttributes(sqlLex));
                } else {
                    outerAttributes.addAll(new FunctionHeader().getAttributes(sqlLex));
                }
            }

        } catch (JSQLParserException je) {
            logger.debug("Errors while parsing");
        }

        return new Implication<QueryAttribute>(innerAttributes, outerAttributes, innerResults, outerResults);
    }

    private List<QueryAttribute> getInnerArguments(Query query, String sqlQuery) throws JSQLParserException {
        return query.getAttributes(sqlQuery);
    }

    private List<QueryAttribute> getInnerResults(Query query, String sqlQuery) throws JSQLParserException {
        return query.getAttributes(sqlQuery);
    }
}

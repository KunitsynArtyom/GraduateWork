package diploma.logic.parsers;

import diploma.logic.parsers.entities.QueryAttribute;
import diploma.logic.parsers.entities.queries.InsertQuery;
import diploma.logic.parsers.entities.queries.Query;
import diploma.logic.parsers.entities.queries.SelectQuery;
import diploma.logic.parsers.entities.queries.UpdateQuery;
import net.sf.jsqlparser.JSQLParserException;

import java.util.List;

/**
 * Created by Артём on 01.04.2017.
 */
public class SQLParser {

    private String sqlQuery;
    public List<QueryAttribute> argumentsList;

    public SQLParser(String sqlQuery){
        this.sqlQuery = sqlQuery;
    }

    public List<QueryAttribute> getArgumentsList() throws JSQLParserException {

        if(sqlQuery.toLowerCase().contains("select")){
            argumentsList = getInnerArguments(new SelectQuery());
        } else if(sqlQuery.toLowerCase().contains("insert")){
            argumentsList = getInnerResults(new InsertQuery());
        } else if(sqlQuery.toLowerCase().contains("update")){
            argumentsList = getInnerResults(new UpdateQuery());
        }

        return argumentsList;
    }

    private List<QueryAttribute> getInnerArguments(Query query) throws JSQLParserException {
        return query.getAttributes(sqlQuery);
    }

    private List<QueryAttribute> getInnerResults(Query query) throws JSQLParserException {
        return query.getAttributes(sqlQuery);
    }
}

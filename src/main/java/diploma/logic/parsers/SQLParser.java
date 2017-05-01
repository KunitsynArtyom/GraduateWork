package diploma.logic.parsers;

import diploma.logic.graphs.prodsys.entities.Implication;
import diploma.logic.parsers.entities.QueryAttribute;
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

    private List<String> sqlQueryList;
    private List<QueryAttribute> attributes;
    private List<QueryAttribute> results;

    public SQLParser(List<String> sqlQueryList) {
        this.sqlQueryList = sqlQueryList;
        this.attributes = new ArrayList<QueryAttribute>();
        this.results = new ArrayList<QueryAttribute>();
    }

    public Implication<QueryAttribute> getImplication() {

        try {

            for (String sqlQuery : sqlQueryList) {
                if (sqlQuery.toLowerCase().contains("select")) {
                    attributes.addAll(getInnerArguments(new SelectQuery(), sqlQuery));
                } else if (sqlQuery.toLowerCase().contains("insert")) {
                    results.addAll(getInnerResults(new InsertQuery(), sqlQuery));
                } else if (sqlQuery.toLowerCase().contains("update")) {
                    results.addAll(getInnerResults(new UpdateQuery(), sqlQuery));
                }
            }

        } catch (JSQLParserException je) {
            logger.debug("Errors while parsing");
        }

        return new Implication<QueryAttribute>(attributes, results);
    }

    private List<QueryAttribute> getInnerArguments(Query query, String sqlQuery) throws JSQLParserException {
        return query.getAttributes(sqlQuery);
    }

    private List<QueryAttribute> getInnerResults(Query query, String sqlQuery) throws JSQLParserException {
        return query.getAttributes(sqlQuery);
    }
}

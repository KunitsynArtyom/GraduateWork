package diploma.logic.parsers.entities.queries;

import diploma.logic.parsers.entities.QueryAttribute;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.update.Update;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артём on 01.04.2017.
 */
public class UpdateQuery implements Query {

    public List<QueryAttribute> getAttributes(String sqlQuery) throws JSQLParserException {
        List<QueryAttribute> innerArgumentsList = new ArrayList<QueryAttribute>();

        Update update = (Update) CCJSqlParserUtil.parse(sqlQuery);
        List<Column> columnList = update.getColumns();

        for (Column column : columnList) {
            innerArgumentsList.add(new QueryAttribute(column.toString()));
        }

        return innerArgumentsList;
    }
}

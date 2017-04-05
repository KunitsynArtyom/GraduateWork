package diploma.logic.parsers.entities.queries;

import diploma.logic.parsers.entities.QueryAttribute;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артём on 02.04.2017.
 */
public class SelectQuery implements Query {

    public List<QueryAttribute> getAttributes(String sqlQuery) throws JSQLParserException {
        List<QueryAttribute> selectArgumentsList = new ArrayList<QueryAttribute>();
        Select select = (Select) CCJSqlParserUtil.parse(sqlQuery);
        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
        List<SelectItem> selectItemsList = plainSelect.getSelectItems();

        for(SelectItem selectItem : selectItemsList){
            selectArgumentsList.add(new QueryAttribute(selectItem.toString()));
        }

        return selectArgumentsList;
    }
}

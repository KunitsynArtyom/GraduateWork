package diploma.logic.parsers.entities.queries;

import diploma.logic.parsers.entities.QueryAttribute;
import net.sf.jsqlparser.JSQLParserException;

import java.util.List;

/**
 * Created by Артём on 01.04.2017.
 */
public interface Query {

    List<QueryAttribute> getAttributes(String sqlQuery) throws JSQLParserException;
}

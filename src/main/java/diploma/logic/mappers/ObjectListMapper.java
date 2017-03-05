package diploma.logic.mappers;

import diploma.logic.entities.ObjectList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 17.02.2017.
 */
public class ObjectListMapper implements RowMapper<ObjectList> {

    public ObjectList mapRow(ResultSet rs, int rowNum) throws SQLException {
        ObjectList objectList = new ObjectList();
        objectList.setConnectionId(rs.getInt("connection_id"));
        objectList.setObjectId(rs.getInt("object_id"));
        return objectList;
    }
}

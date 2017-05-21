package diploma.logic.mappers;

import diploma.logic.entities.ObjectInstanceList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 17.02.2017.
 */
public class ObjectInstanceListMapper implements RowMapper<ObjectInstanceList> {

    public ObjectInstanceList mapRow(ResultSet rs, int rowNum) throws SQLException {
        ObjectInstanceList objectInstanceList = new ObjectInstanceList();
        objectInstanceList.setConnectionInstanceId(rs.getInt("connection_instance_id"));
        objectInstanceList.setObjectInstanceId(rs.getInt("object_instance_id"));
        return objectInstanceList;
    }
}

package diploma.logic.mappers;

import diploma.logic.entities.ObjectInstance;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Артём on 14.02.2017.
 */
public class ObjectInstanceMapper implements RowMapper<ObjectInstance> {

    public ObjectInstance mapRow(ResultSet rs, int rowNum) throws SQLException {
        ObjectInstance objectInstance = new ObjectInstance();
        objectInstance.setId(rs.getInt("object_instance_id"));
        objectInstance.setName(rs.getString("object_instance_name"));
        return objectInstance;
    }
}

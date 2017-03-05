package diploma.logic.mappers;

import diploma.logic.entities.ConnectionInstance;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 17.02.2017.
 */
public class ConnectionInstanceMapper implements RowMapper<ConnectionInstance> {

    public ConnectionInstance mapRow(ResultSet rs, int rowNum) throws SQLException {
        ConnectionInstance connectionInstance = new ConnectionInstance();
        connectionInstance.setId(rs.getInt("connection_instance_id"));
        connectionInstance.setObjectInstanceId(rs.getInt("object_instance_id"));
        connectionInstance.setName(rs.getString("connection_instance_name"));
        return connectionInstance;
    }
}

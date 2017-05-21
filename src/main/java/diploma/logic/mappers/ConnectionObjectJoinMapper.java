package diploma.logic.mappers;

import diploma.logic.entities.ConnectionObjectJoin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Артём on 18.05.2017.
 */
public class ConnectionObjectJoinMapper implements RowMapper<ConnectionObjectJoin> {

    public ConnectionObjectJoin mapRow(ResultSet rs, int rowNum) throws SQLException {
        ConnectionObjectJoin connectionObjectJoin = new ConnectionObjectJoin();
        connectionObjectJoin.setConnectionId(rs.getInt("connection_id"));
        connectionObjectJoin.setObjectId(rs.getInt("object_id"));
        connectionObjectJoin.setConnectionName(rs.getString("connection_name"));
        connectionObjectJoin.setObjectName(rs.getString("obj_name"));
        return connectionObjectJoin;
    }
}

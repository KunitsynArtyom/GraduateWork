package diploma.logic.mappers;

import diploma.logic.entities.Connection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 17.02.2017.
 */
public class ConnectionMapper implements RowMapper<Connection> {

    public Connection mapRow(ResultSet rs, int rowNum) throws SQLException {
        Connection connection = new Connection();
        connection.setId(rs.getInt("connection_id"));
        connection.setSubjectDomainId(rs.getInt("sd_id"));
        connection.setName(rs.getString("connection_name"));
        return connection;
    }
}

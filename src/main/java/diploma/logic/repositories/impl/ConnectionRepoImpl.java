package diploma.logic.repositories.impl;

import diploma.logic.entities.Connection;
import diploma.logic.mappers.ConnectionMapper;
import diploma.logic.repositories.ConnectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 19.02.2017.
 */
@Repository
public class ConnectionRepoImpl implements ConnectionRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_CONN_LIST = "SELECT * FROM \"public\".\"connection\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"connection\" WHERE connection_id = ?";
    private static final String FIND_ID_BY_SD_ID_QUERY = "SELECT * FROM \"public\".\"connection\" WHERE sd_id = ?";

    @Autowired
    public ConnectionRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Connection> getAllConnectionList(){
        return this.template.query(GET_ALL_CONN_LIST, new Object[] {}, new ConnectionMapper());
    }

    public Connection findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new ConnectionMapper());
    }

    public List<Connection> findBySDId(Integer id){
        return this.template.query(FIND_ID_BY_SD_ID_QUERY, new Object[] {id}, new ConnectionMapper());
    }
}

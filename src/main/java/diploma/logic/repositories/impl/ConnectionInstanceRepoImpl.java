package diploma.logic.repositories.impl;

import diploma.logic.entities.ConnectionInstance;
import diploma.logic.mappers.ConnectionInstanceMapper;
import diploma.logic.repositories.ConnectionInstanceRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
@Repository
public class ConnectionInstanceRepoImpl implements ConnectionInstanceRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_CONN_INST_LIST = "SELECT * FROM \"public\".\"connection_instance\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"connection_instance\" WHERE connection_instance_id = ?";
    private static final String FIND_BY_CONN_ID = "SELECT * FROM \"public\".\"connection_instance\" WHERE connection_id = ?";

    @Autowired
    public ConnectionInstanceRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<ConnectionInstance> getAllConnectionInstanceList(){
        return this.template.query(GET_ALL_CONN_INST_LIST, new Object[] {}, new ConnectionInstanceMapper());
    }

    public ConnectionInstance findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new ConnectionInstanceMapper());
    }

    public List<ConnectionInstance> findConnectionInstanceListByConnId(Integer id){
        return this.template.query(FIND_BY_CONN_ID, new Object[] {}, new ConnectionInstanceMapper());
    }
}

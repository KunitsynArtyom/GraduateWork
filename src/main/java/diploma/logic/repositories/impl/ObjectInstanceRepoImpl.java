package diploma.logic.repositories.impl;

import diploma.logic.entities.ObjectInstance;
import diploma.logic.mappers.ObjectInstanceMapper;
import diploma.logic.repositories.ObjectInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
@Repository
public class ObjectInstanceRepoImpl implements ObjectInstanceRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_OBJ_INST_LIST = "SELECT * FROM \"public\".\"object_instance\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"object_instance\" WHERE object_instance_id = ?";
    private static  final String FIND_BY_OBJ_ID = "SELECT * FROM \"public\".\"object_instance\" WHERE object_id = ?";

    @Autowired
    public ObjectInstanceRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<ObjectInstance> getAllObjectInstanceList(){
        return this.template.query(GET_ALL_OBJ_INST_LIST, new Object[] {}, new ObjectInstanceMapper());
    }

    public ObjectInstance findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new ObjectInstanceMapper());
    }

    public List<ObjectInstance> findByObjId(Integer id){
        return this.template.query(FIND_BY_OBJ_ID, new Object[] {id}, new ObjectInstanceMapper());
    }
}

package diploma.logic.repositories.impl;

import diploma.logic.entities.Obj;
import diploma.logic.mappers.ObjMapper;
import diploma.logic.repositories.ObjRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
/**
 * Created by Артём on 18.02.2017.
 */
@Repository
public class ObjRepoImpl implements ObjRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_OBJ_LIST = "SELECT * FROM \"public\".\"object\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"object\" WHERE object_id = ?";
    private static final String FIND_ID_BY_SD_ID_QUERY = "SELECT * FROM \"public\".\"object\" WHERE sd_id = ?";
    private static final String FIND_ID_BY_OBJ_INST_ID_QUERY = "SELECT * FROM \"public\".\"object\" WHERE object_instance_id = ?";

    @Autowired
    public ObjRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Obj> getAllObjList(){
        return this.template.query(GET_ALL_OBJ_LIST, new Object[] {}, new ObjMapper());
    }

    public Obj findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new ObjMapper());
    }

    public List<Obj> findBySDId(Integer id){
        return this.template.query(FIND_ID_BY_SD_ID_QUERY, new Object[] {id}, new ObjMapper());
    }

    public List<Obj> findByObjInstanceId(Integer id){
        return this.template.query(FIND_ID_BY_OBJ_INST_ID_QUERY, new Object[] {id}, new ObjMapper());
    }
}

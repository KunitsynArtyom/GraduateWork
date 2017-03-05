package diploma.logic.repositories.impl;

import diploma.logic.entities.Attribute;
import diploma.logic.mappers.AttributeMapper;
import diploma.logic.repositories.AttributeRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
/**
 * Created by Артём on 19.02.2017.
 */
@Repository
public class AttributeRepoImpl implements AttributeRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_ATT_LIST = "SELECT * FROM \"public\".\"attribute\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"attribute\" WHERE attribute_id = ?";
    private static final String FIND_ID_BY_OBJ_ID_QUERY = "SELECT * FROM \"public\".\"attribute\" WHERE object_id = ?";


    @Autowired
    public AttributeRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Attribute> getAllAttributeList(){
        return this.template.query(GET_ALL_ATT_LIST, new Object[] {}, new AttributeMapper());
    }

    public Attribute findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new AttributeMapper());
    }

    public List<Attribute> findByObjId(Integer id){
        return this.template.query(FIND_ID_BY_OBJ_ID_QUERY, new Object[] {id}, new AttributeMapper());
    }
}

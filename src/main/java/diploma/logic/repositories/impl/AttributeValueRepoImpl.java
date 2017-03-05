package diploma.logic.repositories.impl;

import diploma.logic.repositories.AttributeValueRepo;
import diploma.logic.entities.AttributeValue;
import diploma.logic.mappers.AttributeValueMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
@Repository
public class AttributeValueRepoImpl implements AttributeValueRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_ATT_VAL_LIST = "SELECT * FROM \"public\".\"attribute_value\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"attribute_value\" WHERE attribute_value_id = ?";
    private static final String FIND_ID_BY_ATT_ID_QUERY = "SELECT * FROM \"public\".\"attribute_value\" WHERE attribute_id = ?";

    @Autowired
    public AttributeValueRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<AttributeValue> getAllAttributeValueList(){
        return this.template.query(GET_ALL_ATT_VAL_LIST, new Object[] {}, new AttributeValueMapper());
    }

    public AttributeValue findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new AttributeValueMapper());
    }

    public List<AttributeValue> findByAttributeId(Integer id){
        return this.template.query(FIND_ID_BY_ATT_ID_QUERY, new Object[] {id}, new AttributeValueMapper());
    }
}

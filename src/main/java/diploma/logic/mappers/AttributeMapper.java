package diploma.logic.mappers;

import diploma.logic.entities.Attribute;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 14.02.2017.
 */


public class AttributeMapper implements RowMapper<Attribute> {

    public Attribute mapRow(ResultSet rs, int rowNum) throws SQLException {
        Attribute attribute = new Attribute();
        attribute.setId(rs.getInt("attribute_id"));
        attribute.setObjectId(rs.getInt("object_id"));
        attribute.setName(rs.getString("attribute_name"));
        return attribute;
    }
}

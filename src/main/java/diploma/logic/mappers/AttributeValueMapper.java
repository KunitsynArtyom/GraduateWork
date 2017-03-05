package diploma.logic.mappers;

import diploma.logic.entities.AttributeValue;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Артём on 14.02.2017.
 */
public class AttributeValueMapper implements RowMapper<AttributeValue> {

    public AttributeValue mapRow(ResultSet rs, int rowNum) throws SQLException {
        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setId(rs.getInt("attribute_value_id"));
        attributeValue.setAttributeId(rs.getInt("attribute_id"));
        attributeValue.setAttributeValue(rs.getInt("attribute_value"));
        return attributeValue;
    }
}

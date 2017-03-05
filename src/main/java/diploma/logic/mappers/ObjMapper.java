package diploma.logic.mappers;

import diploma.logic.entities.Obj;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 14.02.2017.
 */


public class ObjMapper implements RowMapper<Obj> {

        public Obj mapRow(ResultSet rs, int rowNum) throws SQLException {
            Obj object = new Obj();
            object.setId(rs.getInt("object_id"));
            object.setSubjectDomainId(rs.getInt("sd_id"));
            object.setObjectInstanceId(rs.getInt("object_instance_id"));
            object.setName(rs.getString("obj_name"));
            return object;
        }
}

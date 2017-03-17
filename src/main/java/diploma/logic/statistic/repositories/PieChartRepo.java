package diploma.logic.statistic.repositories;

import diploma.logic.statistic.entities.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Артём on 17.03.2017.
 */
@Repository
public class PieChartRepo {

    private JdbcTemplate template;

    private static final String GET_OBJ_STAT_LIST = "SELECT sd.sd_name, se.count_obj FROM " +
            "(SELECT obj.sd_id, COUNT(*) count_obj FROM \"public\".\"object\" obj " +
            "GROUP BY sd_id) AS se, \"public\".\"subject_domain\" sd " +
            "WHERE sd.sd_id = se.sd_id";

    @Autowired
    public PieChartRepo(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<KeyValue> getObjectStatList(){
        return this.template.query(GET_OBJ_STAT_LIST, new Object[] {}, new RowMapper(){

            public KeyValue mapRow(ResultSet rs, int rowNum) throws SQLException {
                KeyValue keyValue = new KeyValue();
                keyValue.setKey(rs.getString("sd_name"));
                keyValue.setValue(rs.getString("count_obj"));
                return keyValue;
            }
        });
    }
}

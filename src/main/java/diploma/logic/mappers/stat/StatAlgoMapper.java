package diploma.logic.mappers.stat;

import diploma.logic.entities.stat.StatAlgo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Артём on 28.05.2017.
 */
public class StatAlgoMapper implements RowMapper<StatAlgo> {

    public StatAlgo mapRow(ResultSet rs, int rowNum) throws SQLException {
        StatAlgo statAlgo = new StatAlgo();
        statAlgo.setAdditionalInfo(rs.getString("additional_info"));
        statAlgo.setStatName(rs.getString("stat_name"));
        statAlgo.setStatValue(rs.getDouble("stat_value"));
        return statAlgo;
    }
}

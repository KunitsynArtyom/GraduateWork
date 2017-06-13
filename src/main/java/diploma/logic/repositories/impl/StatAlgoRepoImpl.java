package diploma.logic.repositories.impl;

import diploma.logic.entities.stat.InsertStat;
import diploma.logic.entities.stat.StatAlgo;
import diploma.logic.mappers.stat.StatAlgoMapper;
import diploma.logic.repositories.StatAlgoRepo;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 28.05.2017.
 */
@Repository
public class StatAlgoRepoImpl implements StatAlgoRepo {

    private JdbcTemplate template;
    private DataSource dataSource;

    private static final String GET_DEF_ATT_STAT_LIST = "SELECT st.additional_info, st.stat_name, st.stat_value " +
            "FROM \"public\".\"algo\" al RIGHT JOIN \"public\".\"stat\" st ON st.algo_id = al.algo_id " +
            "WHERE al.algo_name = 'defAttributes' " +
            "ORDER BY st.stat_value;";
    private static final String GET_CONN_STAT_LIST = "SELECT st.additional_info, st.stat_name, st.stat_value " +
            "FROM \"public\".\"algo\" al RIGHT JOIN \"public\".\"stat\" st ON st.algo_id = al.algo_id " +
            "WHERE al.algo_name = 'connections' " +
            "ORDER BY st.stat_name, st.additional_info;";
    private static final String GET_DEF_ATT_ALGO_ID  = "SELECT algo_id " +
            "FROM \"public\".\"algo\" " +
            "WHERE algo_name = 'defAttributes';";
    private static final String GET_CONN_ALGO_ID  = "SELECT algo_id " +
            "FROM \"public\".\"algo\" " +
            "WHERE algo_name = 'connections';";

    private static final String INSERT_STAT = "INSERT INTO \"public\".\"stat\" (algo_id, stat_name, stat_value, additional_info) " +
            "VALUES (?, ?, ?, ?);";

    @Required
    @Resource(name = "statDataSource")
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }

    public List<StatAlgo> getDefiningAttributeStatList(){
        return this.template.query(GET_DEF_ATT_STAT_LIST, new Object[] {}, new StatAlgoMapper());
    }

    public List<StatAlgo> getConnectionsStatList(){
        return this.template.query(GET_CONN_STAT_LIST, new Object[] {}, new StatAlgoMapper());
    }

    public Integer getDefiningAttributesAlgoId(){
        return this.template.queryForObject(GET_DEF_ATT_ALGO_ID, new Object[] {}, Integer.class);
    }

    public Integer getConnectionsAlgoId(){
        return this.template.queryForObject(GET_CONN_ALGO_ID, new Object[] {}, Integer.class);
    }

    public void insertNewStat(InsertStat insertStat){
        this.template.update(INSERT_STAT, new Object[]{
                insertStat.getAlgoId(),
                insertStat.getStatName(),
                insertStat.getStatValue(),
                insertStat.getAdditionalInfo()
        });
    }

    public StatAlgo findById(Integer id){
        return null;
    }
}

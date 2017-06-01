package diploma.logic.repositories;

import diploma.logic.entities.stat.InsertStat;
import diploma.logic.entities.stat.StatAlgo;

import java.util.List;

/**
 * Created by Артём on 28.05.2017.
 */
public interface StatAlgoRepo extends Repo<StatAlgo> {

    List<StatAlgo> getDefiningAttributeStatList();

    List<StatAlgo> getConnectionsStatList();

    Integer getDefiningAttributesAlgoId();

    Integer getConnectionsAlgoId();

    void insertNewStat(InsertStat insertStat);
}

package diploma.logic.algos.services;

import diploma.logic.algos.entities.AlgoConnection;
import diploma.logic.entities.stat.InsertStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Артём on 28.05.2017.
 */
public class StatService {

    public List<InsertStat> convertToInsertStatList(Map<AlgoConnection, Double> map, Integer algoId, String additionalInfo){
        List<InsertStat> insertStatList = new ArrayList<InsertStat>();

        for(Map.Entry entry : map.entrySet()){
            InsertStat tempInsertStat = new InsertStat();

            try{
                tempInsertStat.setAlgoId(algoId);
                tempInsertStat.setStatName(entry.getKey().toString());
                tempInsertStat.setStatValue(Double.parseDouble(entry.getValue().toString()));
                tempInsertStat.setAdditionalInfo(additionalInfo);
            } catch (Exception ex) {throw ex;}

            insertStatList.add(tempInsertStat);
        }

        return insertStatList;
    }
}

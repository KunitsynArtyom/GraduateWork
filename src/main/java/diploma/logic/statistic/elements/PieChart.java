package diploma.logic.statistic.elements;

import diploma.logic.statistic.services.PieChartService;
import diploma.logic.statistic.entities.KeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артём on 17.03.2017.
 */
public class PieChart {

    private List<KeyValue> pieDataList;
    private PieChartService pieChartService;

    public PieChart(){
        pieDataList = new ArrayList<KeyValue>();
        pieChartService = new PieChartService();
    }

    public List<KeyValue> setStatList(){
        List<KeyValue> statObjectList = pieChartService.getStatList();
        for(KeyValue keyValue : statObjectList){
            pieDataList.add(new KeyValue(keyValue.getKey(), keyValue.getValue().toString()));
        }

        return pieDataList;
    }
}

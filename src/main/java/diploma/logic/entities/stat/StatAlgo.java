package diploma.logic.entities.stat;

/**
 * Created by Артём on 28.05.2017.
 */
public class StatAlgo {

    private Double statValue;
    private String statName, additionalInfo;

    public StatAlgo() {

    }

    public StatAlgo(Double statValue,String statName) {
        this.statName = statName;
        this.statValue = statValue;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public Double getStatValue() {
        return statValue;
    }

    public void setStatValue(Double statValue) {
        this.statValue = statValue;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String addtionalInfo) {
        this.additionalInfo = addtionalInfo;
    }
}

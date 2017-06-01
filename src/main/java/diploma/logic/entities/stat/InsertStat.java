package diploma.logic.entities.stat;

/**
 * Created by Артём on 28.05.2017.
 */
public class InsertStat {

    Integer algoId;
    Double statValue;
    String statName, additionalInfo;

    public InsertStat() {

    }

    public InsertStat(Integer algoId, Double statValue,
                      String statName, String additionalInfo) {
        this.algoId = algoId;
        this.statValue = statValue;
        this.statName = statName;
        this.additionalInfo = additionalInfo;
    }

    public Integer getAlgoId() {
        return algoId;
    }

    public void setAlgoId(Integer algoId) {
        this.algoId = algoId;
    }

    public Double getStatValue() {
        return statValue;
    }

    public void setStatValue(Double statValue) {
        this.statValue = statValue;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}

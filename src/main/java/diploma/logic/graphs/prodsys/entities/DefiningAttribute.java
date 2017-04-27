package diploma.logic.graphs.prodsys.entities;

import diploma.logic.parsers.entities.QueryAttribute;

/**
 * Created by Артём on 07.04.2017.
 */
public class DefiningAttribute {

    private QueryAttribute attribute;
    private double measure;

    public DefiningAttribute(QueryAttribute attribute, double measure) {
        this.attribute = attribute;
        this.measure = measure;
    }

    public QueryAttribute getAttribute() {
        return attribute;
    }

    public double getMeasure() {
        return measure;
    }

    @Override
    public String toString(){
        return "[ " + attribute + " : " + measure  + " ]";
    }
}

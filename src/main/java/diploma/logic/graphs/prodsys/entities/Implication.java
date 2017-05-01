package diploma.logic.graphs.prodsys.entities;

import java.util.ArrayList;
import java.util.Collection;

public class Implication<T> {

    private Collection<T> arguments;
    private Collection<T> results;

    public Implication(Collection<T> arguments, Collection<T> results) {
        this.arguments = new ArrayList<T>(arguments);
        this.results = new ArrayList<T>(results);
    }

    public Collection<T> getArguments() {
        return new ArrayList<T>(arguments);
    }

    public Collection<T> getResult() {
        return new ArrayList<T>(results);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append("(");
        boolean notFirst = false;
        for(T argument : arguments){
            if(notFirst){
                stringBuilder.append(", ");
            }
            stringBuilder.append(argument);
            notFirst = true;
        }
        stringBuilder.append(") --> ");
        for(T result : results){
            stringBuilder.append(result);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

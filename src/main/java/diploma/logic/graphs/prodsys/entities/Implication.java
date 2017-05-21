package diploma.logic.graphs.prodsys.entities;

import java.util.ArrayList;
import java.util.Collection;

public class Implication<T> {

    private Collection<T> innerArguments;
    private Collection<T> outerArguments;
    private Collection<T> innerResults;
    private Collection<T> outerResults;

    public Implication(Collection<T> innerArguments, Collection<T> outerArguments, Collection<T> innerResults, Collection<T> outerResults) {
        this.innerArguments = new ArrayList<T>(innerArguments);
        this.outerArguments = new ArrayList<T>(outerArguments);
        this.innerResults = new ArrayList<T>(innerResults);
        this.outerResults = new ArrayList<T>(outerResults);
    }

    public Collection<T> getInnerArguments() {
        return new ArrayList<T>(innerArguments);
    }

    public Collection<T> getOuterArguments() {
        return new ArrayList<T>(outerArguments);
    }

    public Collection<T> getInnerResults() {
        return new ArrayList<T>(innerResults);
    }

    public Collection<T> getOuterResults() {
        return new ArrayList<T>(outerResults);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append("(");
        boolean notFirst = false;
        for(T argument : innerArguments){
            if(notFirst){
                stringBuilder.append(", ");
            }
            stringBuilder.append(argument);
            notFirst = true;
        }
        stringBuilder.append(") --> ");
        for(T result : innerResults){
            stringBuilder.append(result);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

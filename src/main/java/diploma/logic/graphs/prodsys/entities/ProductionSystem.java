package diploma.logic.graphs.prodsys.entities;

import java.util.ArrayList;
import java.util.Collection;

public class ProductionSystem<T> {

    private Collection<Implication<T>> implications;

    public ProductionSystem(Collection<Implication<T>> implications) {
        this.implications = new ArrayList<Implication<T>>(implications);
    }

    public Collection<Implication<T>> getImplications() {
        return new ArrayList<Implication<T>>(implications);
    }
}

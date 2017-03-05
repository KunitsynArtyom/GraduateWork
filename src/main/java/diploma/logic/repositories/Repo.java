package diploma.logic.repositories;

import java.util.List;

/**
 * Created by Артём on 29.01.2017.
 */
public interface Repo<T> {

/*    void insert(T entity);

    void update(T entity);

    void delete(T entity);
*/
    T findById(Integer id);
}

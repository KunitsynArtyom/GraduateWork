package diploma.logic.repositories;

import diploma.logic.entities.Connection;

import java.util.List;

/**
 * Created by Артём on 19.02.2017.
 */
public interface ConnectionRepo extends Repo<Connection> {

    List<Connection> getAllConnectionList();

    List<Connection> findBySDId(Integer id);

    List<String> getAllDistinctSDList();
}

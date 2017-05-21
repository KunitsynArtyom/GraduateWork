package diploma.logic.repositories;

import diploma.logic.entities.ConnectionState;

import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
public interface ConnectionStateRepo extends Repo<ConnectionState> {

    List<ConnectionState> getAllConnectionStateList();
/*
    List<ConnectionState> findIdByConnectionInstanceId(Integer id);*/

    List<ConnectionState> findBySDStateId(Integer id);

    List<Integer> getAllDistinctSDStateBySDId(Integer id);

    List<ConnectionState> findBySDId(Integer id);
}

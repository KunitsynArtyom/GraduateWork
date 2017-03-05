package diploma.logic.repositories;

import diploma.logic.entities.Obj;

import java.util.List;

/**
 * Created by Артём on 18.02.2017.
 */
public interface ObjRepo extends Repo<Obj>{

    List<Obj> getAllObjList();

    List<Obj> findBySDId(Integer id);

    List<Obj> findByObjInstanceId(Integer id);
}

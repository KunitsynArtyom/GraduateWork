package connections;

import diploma.logic.algos.ConnectionAlgorithm;
import diploma.logic.algos.entities.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Артём on 09.04.2017.
 */
public class ConnectionAlgorithmTest {

    private Set<Connection> connectionSet;
    private Set<Obj> objSet;
    private List<List<ConnectionInstance>> connectionInstanceList;
    private List<MassProblem> massProblemList;

    @Test
    public void checkGetConnectionInstanceGroup(){
        ConnectionAlgorithm connectionAlgorithm = new ConnectionAlgorithm();
        connectionAlgorithm.calculate(connectionSet, connectionInstanceList, massProblemList);

    }

    @Before
    public void setUp(){
        objSet = new HashSet<Obj>();
        connectionSet = new HashSet<Connection>();
        connectionInstanceList = new ArrayList<List<ConnectionInstance>>();
        massProblemList = new ArrayList<MassProblem>();

        List<ObjInstance> objectInstances1 = new ArrayList<ObjInstance>();
        objectInstances1.add(new ObjInstance("Винни-Пух"));
        objectInstances1.add(new ObjInstance("Колобок"));
        Obj obj1 = new Obj("Книги", objectInstances1);

        List<ObjInstance> objectInstances2 = new ArrayList<ObjInstance>();
        objectInstances2.add(new ObjInstance("Сказка"));
        Obj obj2 = new Obj("Жанр", objectInstances2);

        List<ObjInstance> objectInstances3 = new ArrayList<ObjInstance>();
        objectInstances3.add(new ObjInstance("Милн"));
        objectInstances3.add(new ObjInstance("Народ"));
        Obj obj3 = new Obj("Автор", objectInstances3);

        objSet.add(obj1);
        objSet.add(obj2);
        objSet.add(obj3);

        Connection conn1 = new Connection(obj1, obj2);
        Connection conn2 = new Connection(obj1, obj3);

        connectionSet.add(conn1);
        connectionSet.add(conn2);

        List<ConnectionInstance> connectionInstanceList1 = new ArrayList<ConnectionInstance>();
        connectionInstanceList1.add(new ConnectionInstance("Винни-Пух", "Сказка"));
        connectionInstanceList1.add(new ConnectionInstance("Винни-Пух", "Милн"));

        List<ConnectionInstance> connectionInstanceList2 = new ArrayList<ConnectionInstance>();
        connectionInstanceList2.add(new ConnectionInstance("Винни-Пух", "Сказка"));
        connectionInstanceList2.add(new ConnectionInstance("Колобок", "Сказка"));
        connectionInstanceList2.add(new ConnectionInstance("Винни-Пух", "Милн"));
        connectionInstanceList2.add(new ConnectionInstance("Колобок", "Народ"));

        List<ConnectionInstance> connectionInstanceList3 = new ArrayList<ConnectionInstance>();
        connectionInstanceList3.add(new ConnectionInstance("Винни-Пух", "Сказка"));
        connectionInstanceList3.add(new ConnectionInstance("Винни-Пух", "Милн"));

        List<ConnectionInstance> connectionInstanceList4 = new ArrayList<ConnectionInstance>();
        connectionInstanceList4.add(new ConnectionInstance("Винни-Пух", "Сказка"));

        connectionInstanceList.add(connectionInstanceList1);
        connectionInstanceList.add(connectionInstanceList2);
        connectionInstanceList.add(connectionInstanceList3);
        connectionInstanceList.add(connectionInstanceList4);

        MassProblem massProblem1 = new MassProblem("Mass Problem 1");
        MassProblem massProblem2 = new MassProblem("Mass Problem 2");
        //MassProblem massProblem3 = new MassProblem("Mass Problem 3");
        massProblemList.add(massProblem1);
        massProblemList.add(massProblem2);
        massProblemList.add(massProblem1);
    }
}

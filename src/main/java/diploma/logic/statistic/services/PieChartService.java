package diploma.logic.statistic.services;

import diploma.logic.statistic.entities.KeyValue;
import diploma.logic.statistic.repositories.PieChartRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Артём on 17.03.2017.
 */
public class PieChartService {

    ApplicationContext context;
    PieChartRepo repo;

    public PieChartService(){
        context = new ClassPathXmlApplicationContext("application-context.xml");
        repo = context.getBean(PieChartRepo.class);
    }

    public List<KeyValue> getStatList(){
        return repo.getObjectStatList();
    }
}

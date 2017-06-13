package diploma.logic.controllers;

import diploma.logic.statistic.elements.PieChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Артём on 17.03.2017.
 */
@Controller
@RequestMapping("/stat")
public class StatController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showAttributeValueList(Model model){

        PieChart pieChart = new PieChart();
        model.addAttribute("pieDataList", pieChart.setStatList());
        return "charts/stat";
    }
}

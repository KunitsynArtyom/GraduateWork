package diploma.logic.controllers;

import diploma.logic.statistic.elements.PieChart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Артём on 17.03.2017.
 */
@Controller
@RequestMapping("/stat")
public class StatController {

    @RequestMapping("/all")
    public String showAttributeValueList(Model model){
        PieChart pieChart = new PieChart();
        model.addAttribute("pieDataList", pieChart.setStatList());
        return "charts/stat";
    }
}

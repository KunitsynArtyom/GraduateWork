package diploma.logic.controllers;

import diploma.logic.algos.services.AcyclicDownTopAlgorithmService;
import diploma.logic.entities.stat.InsertStat;
import diploma.logic.files.entities.FileBucket;
import diploma.logic.files.parser.XMLParser;
import diploma.logic.files.validators.FileValidator;
import diploma.logic.graphs.prodsys.entities.DefiningAttribute;
import diploma.logic.graphs.prodsys.entities.Implication;
import diploma.logic.parsers.SQLFunctionParser;
import diploma.logic.parsers.SQLParser;
import diploma.logic.parsers.entities.QueryAttribute;
import diploma.logic.repositories.StatAlgoRepo;
import net.sf.jsqlparser.JSQLParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артём on 30.03.2017.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    private ApplicationContext context;
    private final String rootPath = System.getProperty("catalina.home");

    @Autowired
    FileValidator fileValidator;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @InitBinder("fileBucket")
    protected void initBinderFileBucket(WebDataBinder binder) {
        binder.setValidator(fileValidator);
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
    public String getSingleUploadPage(ModelMap model) {
        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
        return "files/fileUpload";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String singleFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model) throws IOException, ParserConfigurationException, SAXException, JSQLParserException {
        StatAlgoRepo statAlgoRepo = context.getBean(StatAlgoRepo.class);


        if (result.hasErrors()) {
            return "files/fileUpload";
        } else {

            MultipartFile file = fileBucket.getFile();

            File serverFile = new File(rootPath + File.separator + "tmpFiles" + File.separator + file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(serverFile);
            fos.write(file.getBytes());
            fos.close();

            List<String> sqlQueriesTextList = new XMLParser().parseXMLFile(serverFile);
            List<List<String>> parsedFunctionQueryList = new ArrayList<List<String>>();
            List<Implication<QueryAttribute>> implicationList = new ArrayList<Implication<QueryAttribute>>();

            for (String queryText : sqlQueriesTextList) {
                parsedFunctionQueryList.add(new SQLFunctionParser(queryText).parseSQLFunction());
            }

            for (List<String> list : parsedFunctionQueryList) {
                implicationList.add(new SQLParser(list).getImplication());
            }

            AcyclicDownTopAlgorithmService acyclicDownTopAlgorithmService = new AcyclicDownTopAlgorithmService(implicationList);
            List<DefiningAttribute> definingAttributeList = (List<DefiningAttribute>)acyclicDownTopAlgorithmService.getDefiningAttributes();

            Integer algoId = statAlgoRepo.getDefiningAttributesAlgoId();

            for(DefiningAttribute definingAttribute : definingAttributeList){
                statAlgoRepo.insertNewStat(new InsertStat(algoId, definingAttribute.getMeasure(), definingAttribute.getAttribute().getName(), "definingAttribute"));
            }

            model.addAttribute("vertexList", acyclicDownTopAlgorithmService.getVertexList());
            model.addAttribute("vertexConnectionList", acyclicDownTopAlgorithmService.getVertexConnectionList());
            model.addAttribute("definingAttributes", acyclicDownTopAlgorithmService.getDefiningAttributes());
            return "graphs/graph";
        }
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("errors/error");
        model.addObject("errMsg", ex.getMessage());
        return model;
    }
}

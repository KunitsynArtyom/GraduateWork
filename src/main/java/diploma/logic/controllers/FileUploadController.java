package diploma.logic.controllers;

import diploma.logic.files.entities.FileBucket;
import diploma.logic.files.parser.XMLParser;
import diploma.logic.files.validators.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Артём on 30.03.2017.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    private final String rootPath = System.getProperty("catalina.home");

    @Autowired
    FileValidator fileValidator;

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
    public String singleFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model) throws IOException, ParserConfigurationException, SAXException {
        if (result.hasErrors()) {
            return "files/fileUpload";
        } else {

            MultipartFile file = fileBucket.getFile();

            File serverFile = new File(rootPath + File.separator + file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(serverFile);
            fos.write(file.getBytes());
            fos.close();

            XMLParser xmlParser = new XMLParser();
            List<String> sqlQueriesTextList = xmlParser.parseXMLFile(serverFile);
            model.addAttribute("sqlQueriesTextList", sqlQueriesTextList);
            return "files/fileUploadSuccess";
        }
    }
}

package diploma.logic.files.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артём on 30.03.2017.
 */
public class XMLParser {

    public List<List<String>> parseXMLFile(File file) throws ParserConfigurationException, IOException, SAXException {

        List<List<String>> sqlQueryAttributeLists = new ArrayList<List<String>>();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("query");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                List<String> sqlQueryAttributeList = new ArrayList<String>();
                Element eElement = (Element) nNode;
                for(int i = 0; i < eElement.getElementsByTagName("text").getLength(); i++){
                    sqlQueryAttributeList.add(eElement.getElementsByTagName("text").item(i).getTextContent());
                }

                sqlQueryAttributeLists.add(sqlQueryAttributeList);
            }
        }

        return sqlQueryAttributeLists;
    }
}

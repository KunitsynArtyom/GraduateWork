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

    public List<String> parseXMLFile(File file) throws ParserConfigurationException, IOException, SAXException {

        List<String> sqlQueriesTextList = new ArrayList<String>();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("function");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                sqlQueriesTextList.add(eElement.getElementsByTagName("text").item(0).getTextContent());
            }
        }

        return sqlQueriesTextList;
    }
}

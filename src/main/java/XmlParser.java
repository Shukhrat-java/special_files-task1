import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
    
    public static List<Employee> parseXML(String fileName) {
        List<Employee> employees = new ArrayList<>();
        
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));
            
            Node root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    long id = Long.parseLong(getTagValue("id", element));
                    String firstName = getTagValue("firstName", element);
                    String lastName = getTagValue("lastName", element);
                    String country = getTagValue("country", element);
                    int age = Integer.parseInt(getTagValue("age", element));
                    
                    Employee employee = new Employee(id, firstName, lastName, country, age);
                    employees.add(employee);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return employees;
    }
    
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}

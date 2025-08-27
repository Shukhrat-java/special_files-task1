import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        // XML to JSON (это вторая задача)
        String xmlFileName = "data.xml";
        
        List<Employee> xmlList = XmlParser.parseXML(xmlFileName);
        String xmlJson = JsonWriter.listToJson(xmlList);
        JsonWriter.writeString(xmlJson, "data2.json");
    }
}

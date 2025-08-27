import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        
        List<Employee> list = CsvParser.parseCSV(columnMapping, fileName);
        String json = JsonWriter.listToJson(list);
        JsonWriter.writeString(json, "data.json");
    }
}

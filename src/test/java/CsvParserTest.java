import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CsvParserTest {

    @Test
    public void testParseCSV_validFile_success() {
        // given:
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "src/test/resources/test_data.csv";

        // when:
        List<Employee> result = CsvParser.parseCSV(columnMapping, fileName);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        
        Employee first = result.get(0);
        Assertions.assertEquals(1, first.id);
        Assertions.assertEquals("John", first.firstName);
        Assertions.assertEquals("Smith", first.lastName);
        Assertions.assertEquals("USA", first.country);
        Assertions.assertEquals(25, first.age);
    }

    @Test
    public void testParseCSV_invalidFile_returnsNull() {
        // given:
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "nonexistent_file.csv";

        // when:
        List<Employee> result = CsvParser.parseCSV(columnMapping, fileName);

        // then:
        Assertions.assertNull(result);
    }
}

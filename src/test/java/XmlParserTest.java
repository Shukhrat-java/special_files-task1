import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class XmlParserTest {

    @Test
    public void testParseXML_validFile_success() {
        // given:
        String fileName = "src/test/resources/test_data.xml";

        // when:
        List<Employee> result = XmlParser.parseXML(fileName);

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
    public void testParseXML_invalidFile_returnsEmptyList() {
        // given:
        String fileName = "nonexistent_file.xml";

        // when:
        List<Employee> result = XmlParser.parseXML(fileName);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }
}

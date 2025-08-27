import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class JsonWriterTest {

    @Test
    public void testListToJson_validList_success() {
        // given:
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", "Smith", "USA", 25));
        employees.add(new Employee(2, "Ivan", "Petrov", "RU", 23));

        // when:
        String result = JsonWriter.listToJson(employees);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.contains("John"));
        Assertions.assertTrue(result.contains("Smith"));
        Assertions.assertTrue(result.contains("USA"));
        Assertions.assertTrue(result.contains("25"));
    }

    @Test
    public void testListToJson_emptyList_returnsEmptyArray() {
        // given:
        List<Employee> employees = new ArrayList<>();

        // when:
        String result = JsonWriter.listToJson(employees);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals("[]", result);
    }
}

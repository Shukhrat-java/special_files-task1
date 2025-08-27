import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testEmployeeConstructor_validArguments_success() {
        // given:
        long id = 1;
        String firstName = "John";
        String lastName = "Smith";
        String country = "USA";
        int age = 25;

        // when:
        Employee employee = new Employee(id, firstName, lastName, country, age);

        // then:
        Assertions.assertEquals(id, employee.id);
        Assertions.assertEquals(firstName, employee.firstName);
        Assertions.assertEquals(lastName, employee.lastName);
        Assertions.assertEquals(country, employee.country);
        Assertions.assertEquals(age, employee.age);
    }

    @Test
    public void testEmployeeDefaultConstructor_success() {
        // when:
        Employee employee = new Employee();

        // then:
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(0, employee.id);
        Assertions.assertEquals(0, employee.age);
        Assertions.assertNull(employee.firstName);
        Assertions.assertNull(employee.lastName);
        Assertions.assertNull(employee.country);
    }
}

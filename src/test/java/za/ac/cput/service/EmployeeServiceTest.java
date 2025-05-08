package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeServiceTest {

    private static IEmployeeService service = EmployeeService.getService();
    private static Employee employee = EmployeeFactory.createEmployee("100238456", "Estelle", "Zietsman");


    @Test
    void a_create() {
        Employee created = service.create(employee);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Employee read = service.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Employee newEmployee = new Employee.Builder().copy(employee).setFirstName("Mrs Estelle")
                .build();
        Employee updated = service.update(newEmployee);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_getall() {
        System.out.println(service.getall());
    }
}
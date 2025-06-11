package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeServiceTest {


    @Autowired
    private IEmployeeService service;
    private static Employee employee = EmployeeFactory.createEmployee(
            "100238456",
            "Estelle",
            "Zietsman",
            LocalDate.of(1990, 5, 15),
            "estelle.ziets@gmail.com",
            8005151234567L
    );


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
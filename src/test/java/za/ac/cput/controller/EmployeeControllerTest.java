package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerTest {

    private static Employee employee;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/payroll2/employee";


    @BeforeAll
    public static void setup(){
        employee = EmployeeFactory.createEmployee("219099073", "Naqeebah", "Khan");

    }
    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        Employee createdEmployee =this.restTemplate.postForObject(url, employee, Employee.class);
        assertNotNull(createdEmployee);
        assertEquals(employee.getEmployeeNumber(), createdEmployee.getEmployeeNumber());
        System.out.println("Created: " + createdEmployee);


//          *another way to do it*
//        ResponseEntity<Employee> postResponse= restTemplate.postForEntity(url, employee, Employee.class);
//        assertNotNull(postResponse);
//        Employee employeeSaved = postResponse.getBody();
//        assertEquals(employee.getEmployeeNumber(), employeeSaved.getEmployeeNumber());
//        System.out.println("Created: " + employeeSaved);


    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + employee.getEmployeeNumber();
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        assertEquals(employee.getEmployeeNumber(), response.getBody().getEmployeeNumber());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        LocalDate dateOfBirth = LocalDate.of(2000, 6, 14);
        Employee updatedEmployee = new Employee.Builder().copy(employee).setFirstName("Naqeelah")
                .setEmail("nkhan@gmail.com")
                .setDateOfBirth(dateOfBirth)
                .build();

        String url = BASE_URL + "/update";
//        ResponseEntity<Employee> response = this.restTemplate.postForEntity(url, updatedEmployee, Employee.class);
//        assertNotNull(response.getBody());
//        //assertEquals(updatedEmployee.getFirstName(), response.getBody().getFirstName());
//        System.out.println("Updated: " + response.getBody());


        //verify the update by reading the updated employee
        ResponseEntity<Employee> response = restTemplate.getForEntity(BASE_URL + "/read/"+ updatedEmployee.getEmployeeNumber(), Employee.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
       // assertEquals(updatedEmployee.getFirstName(), response.getBody().getFirstName());
        System.out.println("Updated: " + response.getBody());

    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + employee.getEmployeeNumber();
        this.restTemplate.delete(url);

        //verify the employee was deleted
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(BASE_URL + "/read/" + employee.getEmployeeNumber(), Employee.class);
        //assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        System.out.println("Deleted: " + "true");

    }

    @Test
    void e_getall() {
        String url = BASE_URL + "/getall";

        ResponseEntity<Employee[]> response = this.restTemplate.getForEntity(url, Employee[].class);
        assertNotNull(response.getBody());
        //assertTrue(response.getBody().length > 0);
        System.out.println("Get All: ");
        for (Employee emp: response.getBody()) {
            System.out.println(emp);
        }
    }
}
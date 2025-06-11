package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Employee;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeFactoryTest {

    private static Employee e1 = EmployeeFactory.createEmployee(
            "30011466",
            "Temuso",
            "Makhurane");

    private static Employee e2 = EmployeeFactory.createEmployee(
            "30011469",
            "Estelle",
            "Zietsman",
            LocalDate.of(1974, 2, 12),
            "Zietsman@cput.ac.za",
            74120252100089L);

    private static Employee e3 = EmployeeFactory.createEmployee(
            "30011234",
            "Amlan",
            "Mukherjee",
            LocalDate.of(1995, 3, 15),
            "amlan@gmail.com",
            2012125216089L);


    @Test
    @Order(1)
    public void testCreateEmployee(){
        assertNotNull(e1);
        System.out.println(e1.toString());
    }

    @Test
    @Order(2)
    public void testCreateEmployeeWithAllAttributes(){
        assertNotNull(e2);
        System.out.println(e2.toString());

    }

    @Test
    @Order(3)
    public void testCreateEmployeeThatFails(){
        //fail();
        assertNotNull(e3);
        System.out.println(e3.toString());
    }

    @Test
    @Order(4)
    @Disabled
    public void testNotImplemented(){
        //TODO
    }

}
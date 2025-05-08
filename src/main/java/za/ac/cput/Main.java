package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.time.LocalDate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);




        //LocalDate date = LocalDate.now();

        //Employee e1 = EmployeeFactory.createEmployee("12345","Wilhem",
                //"Rothman","rothman@cput.ac.za", date,
                //"90120254216087");



       // System.out.println(e1.toString());

    }
}
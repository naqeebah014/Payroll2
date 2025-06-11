package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

//imutability


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private String employeeNumber;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private long longId;

    //contact here

    protected Employee() {

    }

    //add constructor later here
    public Employee(Builder builder){
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.dateOfBirth = builder.dateOfBirth;
        this.longId = builder.longId;

    }


    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public long getLongId() {
        return longId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", identityNumber='" + longId + '\'' +
                '}';
    }

    public static class Builder{
        //Attributes
        private String employeeNumber;
        private String firstName;
        private String lastName;
        private String email;
        private LocalDate dateOfBirth;
        private long longId;


        //Setters
        public Builder setEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setLongId(long longId) {
            this.longId = longId;
            return this;
        }

        //optional
        public Builder copy(Employee employee) {
            this.employeeNumber = employee.employeeNumber;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.email = employee.email;
            this.dateOfBirth = employee.dateOfBirth;
            this.longId = employee.longId;
            return this;
        }

        //very important, must do!!
        public Employee build(){

            return new Employee(this);
        }

    }

}

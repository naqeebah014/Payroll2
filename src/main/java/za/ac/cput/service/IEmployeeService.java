package za.ac.cput.service;

import za.ac.cput.domain.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee, String>{

    boolean delete(String id);

    List<Employee> getall();


}

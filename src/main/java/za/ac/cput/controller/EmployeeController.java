package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return this.service.create(employee);
    }

    @GetMapping("/read/{employeeNumber}")
    public Employee read(@PathVariable String employeeNumber) {
        return this.service.read(employeeNumber);
    }

    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return this.service.update(employee);
    }

    @DeleteMapping("/delete/{employeeNumber}")
    public boolean delete(@PathVariable String employeeNumber) {
        return service.delete(employeeNumber);
    }

    @GetMapping("/getall")
    public List<Employee> getAll() {
        return this.service.getall();
    }



}

package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    private static IEmployeeService service;

    private  IEmployeeRepository repository;


    private EmployeeService() {
        repository = EmployeeRepository.getRepository();
    }


    //singleton
    public static IEmployeeService getService() {
        if (service == null){
            service = new EmployeeService();
        }
        return service;
    }



    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }

    @Override
    public boolean delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public List<Employee> getall() {
        return this.repository.getAll();
    }

    //add more customized employee functionality
}

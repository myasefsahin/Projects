package com.proje.example.Service;

import com.proje.example.Enitity.Employee;
import com.proje.example.Repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Transactional
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee add(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee getOneEmployee(int id){
        return employeeRepo.findById(id).orElse(null);
    }

    public Employee  UpdateEmployee(int id,Employee newEmployee){
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()){
            Employee foundEmployee = employee.get();
            foundEmployee.setName(newEmployee.getName());
            foundEmployee.setSurname(newEmployee.getSurname());
            employeeRepo.save(foundEmployee);
            return foundEmployee;
        }
        else{
            return  null;
        }
    }
    public void  delete(int id){
        employeeRepo.deleteById(id);
    }

}

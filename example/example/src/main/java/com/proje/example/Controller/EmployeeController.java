package com.proje.example.Controller;

import com.proje.example.Enitity.Employee;
import com.proje.example.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }
    @PutMapping("/{id}")
    public Employee  UpdateEmployee(@PathVariable int id,@RequestBody Employee newEmployee) {
        return employeeService.UpdateEmployee(id,newEmployee);
    }

    @GetMapping("/{id}")
    public Employee getOneEmployee(@PathVariable int id) {
        return employeeService.getOneEmployee(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

}

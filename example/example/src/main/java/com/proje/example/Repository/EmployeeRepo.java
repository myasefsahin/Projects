package com.proje.example.Repository;

import com.proje.example.Enitity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}

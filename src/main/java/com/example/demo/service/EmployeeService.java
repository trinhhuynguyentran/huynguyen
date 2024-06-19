package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee getById(Long id){
        Optional<Employee> employee =employeeRepository.findById(id);
        return employee.get();
    }

    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public void  save(Employee employee){
        employeeRepository.save(employee);
    }
    public void delete (Long id){
        employeeRepository.deleteById(id);
    }
}

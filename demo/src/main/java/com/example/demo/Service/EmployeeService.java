package com.example.demo.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        System.out.print(employeeRepository.findAll());
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        System.out.print(id);
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(String id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName() != null ? employeeDetails.getName() : employee.getName());
            employee.setDept(employeeDetails.getDept() != null ? employeeDetails.getDept() : employee.getDept());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}

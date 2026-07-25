package com.example.cangqiong.Service;

import com.example.cangqiong.entity.Employee;
import com.example.cangqiong.repository.EmployeeRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmpolyeeService {
    @Autowired
    private EmployeeRepositroy employeerepositroy;
    public Employee saveEmployee(Employee employee){
        return employeerepositroy.save(employee);
    }
    public Employee findEmployee(Employee employee){
        return employeerepositroy.findByEmployeenameOrIdemployeeOrIdnumber(employee.getEmployeename(),employee.getIdemployee(),employee.getIdnumber());
    }
    public List<Employee> pullAllEmployee(){
        return employeerepositroy.findAll();
    }
}

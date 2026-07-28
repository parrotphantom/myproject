package com.example.cangqiong.repository;

import com.example.cangqiong.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositroy extends JpaRepository<Employee, Long> {

    Employee findByEmployeenameOrIdemployeeOrIdnumber(String str0,String str1, String str2);

    Employee findByEmployeenameOrIdemployeeOrIdnumberOrPassword(String employeename, String idemployee, String idnumber, String password);
}

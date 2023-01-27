package com.example.spring.DAO;

import com.example.spring.mapper.EmployeeRowMapper;
import com.example.spring.modell.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface EmployeeDAO  {
    public  void createEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public List<Employee> getAllEmployees();

    public void updateEmployee(Employee employee);

    public void deleteEmployee(Long id);

    public Employee getEmployeeByEmailAndPassword(String email, String password) ;

    @Autowired
     public static final
     JdbcTemplate jdbcTemplate = new JdbcTemplate();



}


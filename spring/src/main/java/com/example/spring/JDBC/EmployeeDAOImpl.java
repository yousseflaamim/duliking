package com.example.spring.JDBC;

import com.example.spring.DAO.EmployeeDAO;
import com.example.spring.mapper.EmployeeRowMapper;
import com.example.spring.modell.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createEmployee(Employee employee) {
        String SQL = "insert into employee (firstName, lastName, email, password) values (?, ?, ?, ?)";
        jdbcTemplate.update(SQL, employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getPassword());
    }
    public Employee getEmployeeById(int id) {
        String SQL = "select * from employee where id = ?";
        Employee employee = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new EmployeeRowMapper());
        return employee;
    }
    public List<Employee> getAllEmployees() {
        String SQL = "select * from employee";
        List<Employee> employees = jdbcTemplate.query(SQL, new EmployeeRowMapper());
        return employees;
    }
    public void updateEmployee(Employee employee) {
        String SQL = "update employee set firstName = ?, lastName = ?, email = ?, password = ? where id = ?";
        jdbcTemplate.update(SQL, employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPassword(), employee.getId());
    }
    public void deleteEmployee(int id) {
        String SQL = "delete from employee where id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public Employee getEmployeeByEmailAndPassword(String email, String password) {
        try {
            String sql = "SELECT * FROM employee WHERE email = ? AND password = ?";
            Employee employee=jdbcTemplate.queryForObject(sql,
                    new Object[] { email, password }, new EmployeeRowMapper());
            return employee;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    }

   /* private final class EmployeeMapper implements RowMapper<Employee> {
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setFirstName(rs.getString("firstName"));
            employee.setLastName(rs.getString("lastName"));
            employee.setEmail(rs.getString("email"));
            employee.setPassword(rs.getString("password"));
            return employee;
        }


    }*/



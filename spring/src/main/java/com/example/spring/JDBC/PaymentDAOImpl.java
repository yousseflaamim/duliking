package com.example.spring.JDBC;


import com.example.spring.DAO.PaymentDAO;
import com.example.spring.mapper.PaymentRowMapper;
import com.example.spring.modell.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createPayment(Payment payment) {

        String sql = "INSERT INTO payment ( title, description,category, amount, employeeId) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, payment.getTitle(), payment.getDescription(),
                payment.getCategory(),payment.getAmount(),payment.getEmployeeId());
    }

    public Payment getPaymentById(int id) {
        String SQL = "select * from payment where id = ?";
        Payment payment = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new PaymentRowMapper());
        return payment;
    }

    public List<Payment> getAllPayments() {
        String SQL = "select * from payment";
        List<Payment> payments = jdbcTemplate.query(SQL, new PaymentRowMapper());
        return payments;
    }

    public void updatePayment(Payment payment) {
        String sql = "update payment set title =  ?, description = ?, category = ?, amount = ?,employeeId=? where id = ?";
        jdbcTemplate.update(sql, payment.getTitle(), payment.getDescription(),
                payment.getCategory(), payment.getAmount(), payment.getId(),payment.getEmployeeId());
    }


    @Override
    public void deletePayment(int id) {
        String sql ="delete from payment where id =?";
        jdbcTemplate.update(sql,id);
    }








}

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

        String SQL = "insert into payment (title, date, description, category, amount) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, payment.getTitle(), payment.getDate(), payment.getDescription(),
                payment.getCategory(), payment.getAmount());
    }

    public Payment getPaymentById(Long id) {
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
        String sql = "update payment set title = ?, date = ?, description = ?, category = ?, amount = ? where id = ?";
        jdbcTemplate.update(sql, payment.getTitle(), payment.getDate(), payment.getDescription(),
                payment.getCategory(), payment.getAmount(), payment.getId());
    }

    @Override
    public void deletePayment(Long id) {
        String sql ="delete from payment where id =?";
        jdbcTemplate.update(sql,id);
    }



}
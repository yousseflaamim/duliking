package com.example.spring.mapper;

import com.example.spring.modell.Payment;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.math.BigDecimal.*;

public class PaymentRowMapper implements RowMapper<Payment> {
    @Override
    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException, SQLException {
        Payment payment = new Payment();
        payment.setId(rs.getInt("id"));
        payment.setTitle(rs.getString("title"));
        payment.setDescription(rs.getString("description"));
        payment.setCategory(rs.getString("category"));
        //payment.setEmployeeId(rs.getInt("employee_id"));
        payment.setAmount(rs.getInt("amount"));
      //  payment.setDate(rs.getDate("date"));
        return payment;
    }
}

package com.example.spring.DAO;

import com.example.spring.modell.Payment;

import java.util.List;

public interface PaymentDAO {
    public void createPayment(Payment payment);
    public Payment getPaymentById(int id);
    public List<Payment> getAllPayments();
    public void updatePayment(Payment payment);
    public void deletePayment(int id);
}

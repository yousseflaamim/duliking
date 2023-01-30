package com.example.spring.controller;

import com.example.spring.DAO.EmployeeDAO;
import com.example.spring.DAO.PaymentDAO;
import com.example.spring.modell.Employee;
import com.example.spring.modell.Payment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private PaymentDAO paymentDAO;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute Employee employee) {
        employeeDAO.createEmployee(employee);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email, @RequestParam String password, Model model) {
        Employee employee = employeeDAO.getEmployeeByEmailAndPassword(email, password);
        if (employee == null) {
           //
            model.addAttribute("message", "Invalid email or password.");
            return "login";

        } else {
            model.addAttribute("employee", employee);
            return "redirect:/invoices";
        }
    }

    @GetMapping("/invoices")
    public String invoices(Model model) {
        List<Payment> payments = paymentDAO.getAllPayments();
        model.addAttribute("payments", payments);
        return "invoices";
    }

    @GetMapping("/payment")
    public String paymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "edit";
    }

    @PostMapping("/payment")
    public String paymentSubmit(@ModelAttribute Payment payment) {

        paymentDAO.createPayment(payment);
        return "redirect:/invoices";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        Payment payment = paymentDAO.getPaymentById(id);
        model.addAttribute("payment", payment);
        return "edit";
    }

    @PostMapping("/edit")
    public String editSubmit(@ModelAttribute Payment payment) {
        paymentDAO.updatePayment(payment);
        return "redirect:/invoices";
    }

    @GetMapping("/delete")
    public String deletePayment(@RequestParam int id) {
        paymentDAO.deletePayment(id);
        return "redirect:/invoices";
    }
}



package com.example.spring.modell;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class Payment {
    private int id;
    private String title;
 //  @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm",shape = JsonFormat.Shape.STRING)
   // private Date date;
    private String description;
    private String category;
    private int amount;

    private int employeeId;



    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

 //   public Date getDate() {
     //   return date;
   // }

  //  public void setDate(Date date) {
   //     this.date = date;
  //  }
  public int getEmployeeId() {
      return employeeId;
  }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", title='" + title + '\'' +
             //   ", date=" + date +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ",  employeeId='" +  employeeId + '\'' +
                ", amount=" + amount +

                '}';
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

}

package com.example.microservice.model;

import jakarta.persistence.*;

@Entity
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private double bankBalance;
    private String bankName;
    private String bankAccountNumber;

    // Constructor, getters and setters
    public Financial() {}

    public Financial(User user, double bankBalance, String bankName, String bankAccountNumber) {
        this.user = user;
        this.bankBalance = bankBalance;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNumber(){
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber){
        this.bankAccountNumber = bankAccountNumber;
    }
}

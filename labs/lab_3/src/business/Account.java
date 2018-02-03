/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 * A Class to hold all the account details
 *  
 * @author Raghavan
 */
public class Account {
    private String routingNumber;
    private String accountNumber;
    private String bankName;
    private double balance;
    private Date createdOn;
    private Date updatedOn;

    public Account() {
        this.routingNumber = "n/a";
        this.accountNumber = "n/a";
        this.bankName = "n/a";
        this.balance = 0.0;
        this.createdOn = new Date();
        this.updatedOn = new Date();
    }

    public Account(String routingNumber, String accountNumber, String bankName, double balance, Date createdOn, Date updatedOn) {
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    
    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
    
    @Override
    public String toString() {
        return accountNumber;
    }
}

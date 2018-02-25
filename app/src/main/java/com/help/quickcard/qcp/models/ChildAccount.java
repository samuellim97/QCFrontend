package com.help.quickcard.qcp.models;

/**
 * Created by shath on 25/02/18.
 */
public class ChildAccount {
    public String accountName;
    public double balance;
    public boolean isActive;

    public ChildAccount(String accountName) {
        this.accountName = accountName;
        this.balance = 0.0;
        this.isActive = false;
    }

    public ChildAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public ChildAccount(String accountName, double balance, boolean isActive) {
        this.accountName = accountName;
        this.balance = balance;
        this.isActive = isActive;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

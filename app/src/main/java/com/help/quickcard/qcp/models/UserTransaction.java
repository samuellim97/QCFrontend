package com.help.quickcard.qcp.models;

/**
 * Transaction model
 * Created by shath on 24/02/18.
 */

public class UserTransaction {
    private String itemName, companyName, amount;

    public UserTransaction(String itemName, String companyName, String amount) {
        this.itemName = itemName;
        this.companyName = companyName;
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAmount() {
        return amount;
    }
}

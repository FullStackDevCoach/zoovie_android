package com.example.zoovienew.Hosts.Model;

public class TransactionModel {
    String transactionAmount;

    public TransactionModel(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}

package com.mrq.backend.models;

public class CashierRequestModel {
    private String cashierName;
    private double totalCash;
    private String counterName;

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }
}

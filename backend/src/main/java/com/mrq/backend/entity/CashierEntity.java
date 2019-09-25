package com.mrq.backend.entity;


import com.mrq.backend.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "cashier")
public class CashierEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 50)
    private String cashierName;

    @Column(nullable = false, length = 50)
    private String counterName;

    private double totalCash;

    private String status = "Active";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String cashierId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }


}

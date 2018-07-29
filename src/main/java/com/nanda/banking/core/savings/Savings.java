package com.nanda.banking.core.savings;

import com.nanda.banking.core.common.Common;
import com.nanda.banking.core.customer.Customer;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "m_savings")
public class Savings {
    @Id
    private UUID id;

    private Long identifier;

    private double amount;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Savings(UUID id) {
        this.setId(id);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    Savings() {

    }

    public Savings(Customer customer) {
        this.customer = customer;
        this.id = UUID.randomUUID();
        this.active = true;
        this.amount = 0;
        this.identifier = Common.getGeneratedLong();
    }
}

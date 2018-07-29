package com.nanda.banking.core.transaction;

import com.nanda.banking.core.channelLog.ChannelLog;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "m_transaction")
public class Transaction {
    @Id
    private UUID id;

    private Date systemDate;
    private int typeCode;
    private int statusCode;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "channel_log_id")
    private ChannelLog channelLog;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ChannelLog getChannelLog() {
        return channelLog;
    }

    public void setChannelLog(ChannelLog channelLog) {
        this.channelLog = channelLog;
    }

    public Transaction() {
        this.setId(UUID.randomUUID());
        this.setSystemDate(new Date());
    }
}

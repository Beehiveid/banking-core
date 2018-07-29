package com.nanda.banking.core.channelLog;

import com.nanda.banking.core.channel.Channel;
import com.nanda.banking.core.common.Common;
import com.nanda.banking.core.savings.Savings;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "m_channel_log")
public class ChannelLog {
    @Id
    private UUID id;

    @Column(unique = true)
    private long identifier;

    @Column(name = "pin_code")
    private String pinCode;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "savings_id")
    private Savings savings;

    public Savings getSavings() {
        return savings;
    }

    private void setSavings(Savings savings) {
        this.savings = savings;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getIdentifier() {
        return identifier;
    }

    private void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public String getPinCode() {
        return pinCode;
    }

    private void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    Channel getChannel() {
        return channel;
    }

    private void setChannel(Channel channel) {
        this.channel = channel;
    }

    ChannelLog() {

    }

    public ChannelLog(Savings savings, Channel channel){
        this.setSavings(savings);
        this.setId(UUID.randomUUID());
        this.setChannel(channel);

        if (channel.isSecure()){
            this.setPinCode("abcde12345");
        }else{
            this.setPinCode(null);
        }

        this.setIdentifier(Common.getGeneratedLong());
    }
}

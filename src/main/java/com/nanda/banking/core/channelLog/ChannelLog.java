package com.nanda.banking.core.channelLog;

import com.nanda.banking.core.channel.Channel;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ChannelLog() {

    }
}

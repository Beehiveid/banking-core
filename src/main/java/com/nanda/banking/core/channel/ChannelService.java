package com.nanda.banking.core.channel;

import java.util.List;

public interface ChannelService {
    List<Channel> findAll();
    Channel findById(int id);
    void save(Channel channel);
    void save(List<Channel> channels);
}

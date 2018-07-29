package com.nanda.banking.core.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<Channel> findAll() {
        return channelRepository.findAll();
    }

    @Override
    public Channel findById(int id) {
        Optional<Channel> channelOptional = channelRepository.findById(id);
        Channel channel = new Channel();
        if(channelOptional.isPresent()){
            channel = channelOptional.get();
        }
        return channel;
    }

    @Override
    public void save(Channel channel) {
        channelRepository.save(channel);
    }

    @Override
    public void save(List<Channel> channels) {
        channelRepository.saveAll(channels);
    }

    @Override
    public List<Channel> findAutoAssignChannel(boolean b) {
        return channelRepository.findByAutoAssign(b);
    }
}

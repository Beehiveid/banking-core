package com.nanda.banking.core.channelLog;

import com.nanda.banking.core.channel.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChannelLogServiceImpl implements ChannelLogService {
    @Autowired
    private ChannelLogRepository channelLogRepository;

    @Override
    public List<ChannelLog> findAll() {
        return channelLogRepository.findAll();
    }

    @Override
    public ChannelLog findById(UUID id) {
        Optional<ChannelLog> channelLogOptional = channelLogRepository.findById(id);
        ChannelLog channelLog = new ChannelLog();
        if(channelLogOptional.isPresent()){
            channelLog = channelLogOptional.get();
        }
        return channelLog;
    }

    @Override
    public void save(ChannelLog channelLog) {
        channelLog.setId(UUID.randomUUID());
        channelLogRepository.save(channelLog);
    }

    @Override
    public void save(List<ChannelLog> channelLogs) {
        channelLogs.forEach(
                channelLog -> channelLog.setId(UUID.randomUUID())
        );
        channelLogRepository.saveAll(channelLogs);
    }
}

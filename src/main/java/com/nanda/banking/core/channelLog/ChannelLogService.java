package com.nanda.banking.core.channelLog;

import java.util.List;
import java.util.UUID;

public interface ChannelLogService {
    List<ChannelLog> findAll();
    ChannelLog findById(UUID id);
    void save(ChannelLog channelLog);
    void save(List<ChannelLog> channelLogs);
}

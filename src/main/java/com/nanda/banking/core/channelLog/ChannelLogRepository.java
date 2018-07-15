package com.nanda.banking.core.channelLog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChannelLogRepository extends JpaRepository<ChannelLog, UUID> {
}

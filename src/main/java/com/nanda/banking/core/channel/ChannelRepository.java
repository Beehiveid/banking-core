package com.nanda.banking.core.channel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel,Integer> {
    List<Channel> findByAutoAssign(boolean b);
}

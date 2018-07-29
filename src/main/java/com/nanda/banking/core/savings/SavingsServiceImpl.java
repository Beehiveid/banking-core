package com.nanda.banking.core.savings;

import com.nanda.banking.core.channel.Channel;
import com.nanda.banking.core.channel.ChannelServiceImpl;
import com.nanda.banking.core.channelLog.ChannelLog;
import com.nanda.banking.core.channelLog.ChannelLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SavingsServiceImpl implements SavingsService {
    @Autowired
    private SavingsRepository savingsRepository;

    @Autowired
    private ChannelServiceImpl channelService;

    @Autowired
    private ChannelLogServiceImpl channelLogService;

    @Override
    public List<Savings> findAll() {
        return savingsRepository.findAll();
    }

    @Override
    public Savings findById(UUID id) {
        Optional<Savings> savingsOptional = savingsRepository.findById(id);
        Savings savings = new Savings();
        if(savingsOptional.isPresent()){
            savings = savingsOptional.get();
        }
        return savings;
    }

    @Override
    public void save(Savings savings) {
        savingsRepository.save(savings);
    }

    @Override
    public void save(List<Savings> savings) {
        List<Savings> submittedSavings = savingsRepository.saveAll(savings);

        List<Channel> channels = channelService.findAutoAssignChannel(true);

        submittedSavings.forEach(
                savingsItem ->{
                    List<ChannelLog> channelLogs = new ArrayList<>();
                    channels.forEach(
                            channelItem->{
                                ChannelLog channelLog = new ChannelLog(savingsItem, channelItem);
                                channelLogs.add(channelLog);
                            }
                    );

                    channelLogService.save(channelLogs);
                }
        );
    }
}

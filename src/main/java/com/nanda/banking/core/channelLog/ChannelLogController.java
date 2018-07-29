package com.nanda.banking.core.channelLog;

import com.nanda.banking.core.channel.Channel;
import com.nanda.banking.core.savings.Savings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/channel/log")
public class ChannelLogController {
    @Autowired
    private ChannelLogServiceImpl channelLogService;

    @GetMapping
    public List<ChannelLog> index(){
        return channelLogService.findAll();
    }

    @GetMapping("/{id}")
    public ChannelLog findById(@PathVariable("id")UUID id){
        return channelLogService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody List<ChannelLog> channelLogs){
        channelLogs.forEach(
                item->{
                    Savings savings = new Savings(item.getSavings().getId());
                    Channel channel = new Channel(item.getChannel().getId());
                    ChannelLog channelLog = new ChannelLog(savings, channel);
                    channelLogService.save(channelLog);
                }
        );
    }
}

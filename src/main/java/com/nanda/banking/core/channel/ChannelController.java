package com.nanda.banking.core.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channel")
public class ChannelController {
    @Autowired
    private ChannelServiceImpl channelService;

    @GetMapping
    public List<Channel> index(){
        return channelService.findAll();
    }

    @GetMapping("/{id}")
    public Channel findById(@PathVariable("id")int id){
        return channelService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody List<Channel> channels){
        channelService.save(channels);
    }
}

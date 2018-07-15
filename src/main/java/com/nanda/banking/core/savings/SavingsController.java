package com.nanda.banking.core.savings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/savings")
public class SavingsController {
    @Autowired
    private SavingsServiceImpl savingsService;

    @GetMapping
    public List<Savings> index(){
        return savingsService.findAll();
    }

    @GetMapping("/{id}")
    public Savings findById(@PathVariable("id") UUID id){
        return savingsService.findById(id);
    }

    @PostMapping
    public void create(List<Savings> savings){
        savingsService.save(savings);
    }
}

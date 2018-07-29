package com.nanda.banking.core.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionServiceImpl transactionService;

    @GetMapping
    public List<Transaction> index(){
        return transactionService.findAll();
    }

    @GetMapping("/{id")
    public Transaction findById(@PathVariable("id")UUID id){
        return transactionService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Transaction transaction){
        transactionService.save(transaction);
    }
}

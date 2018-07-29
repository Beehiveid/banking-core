package com.nanda.banking.core.transaction;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(UUID id) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        return transactionOptional.orElse(null);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}

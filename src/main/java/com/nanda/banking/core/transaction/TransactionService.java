package com.nanda.banking.core.transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    List<Transaction> findAll();
    Transaction findById(UUID id);
    void save(Transaction transaction);

    void updateAmount(Transaction submitted);
}

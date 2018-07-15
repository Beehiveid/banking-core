package com.nanda.banking.core.savings;

import java.util.List;
import java.util.UUID;

public interface SavingsService {
    List<Savings> findAll();
    Savings findById(UUID id);
    void save(Savings savings);
    void save(List<Savings> savings);
}

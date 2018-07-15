package com.nanda.banking.core.savings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SavingsServiceImpl implements SavingsService {
    @Autowired
    private SavingsRepository savingsRepository;

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
        savingsRepository.saveAll(savings);
    }
}

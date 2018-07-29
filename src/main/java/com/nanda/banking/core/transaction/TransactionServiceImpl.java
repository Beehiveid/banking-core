package com.nanda.banking.core.transaction;

import com.nanda.banking.core.channelLog.ChannelLog;
import com.nanda.banking.core.channelLog.ChannelLogServiceImpl;
import com.nanda.banking.core.savings.Savings;
import com.nanda.banking.core.savings.SavingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ChannelLogServiceImpl channelLogService;

    @Autowired
    private SavingsServiceImpl savingsService;

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
        Transaction submitted = transactionRepository.save(transaction);

        this.updateAmount(submitted);
    }

    @Override
    public void updateAmount(Transaction submitted) {
        Savings saving = submitted.getChannelLog().getSavings();

        if(submitted.getTypeCode() == 201){
            saving.setAmount(saving.getAmount() - submitted.getAmount());
        }else{
            saving.setAmount(saving.getAmount() + submitted.getAmount());
        }

        savingsService.save(saving);

        submitted.setStatusCode(200);

        transactionRepository.save(submitted);
    }
}

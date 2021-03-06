package com.nanda.banking.core.customer;

import com.nanda.banking.core.savings.Savings;
import com.nanda.banking.core.savings.SavingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SavingsServiceImpl savingsService;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(UUID id) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        Customer customer = new Customer();

        if(customerOpt.isPresent()){
            customer = customerOpt.get();
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        customer.setId(UUID.randomUUID());
        customerRepository.save(customer);
    }

    void save(List<Customer> customer) {
        customer.forEach(
                item -> item.setId(UUID.randomUUID())
        );

        List<Customer> insertedCustomer = customerRepository.saveAll(customer);
        List<Savings> savingsList = new ArrayList<>();

        insertedCustomer.forEach(
                newCustomer -> {
                    Savings newSavings = new Savings(newCustomer);
                    savingsList.add(newSavings);
                }
        );

        savingsService.save(savingsList);
    }
}

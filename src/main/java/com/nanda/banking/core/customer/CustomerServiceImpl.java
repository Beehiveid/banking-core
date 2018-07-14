package com.nanda.banking.core.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

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
}

package com.nanda.banking.core.customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(UUID id);
    void save(Customer customer);
}

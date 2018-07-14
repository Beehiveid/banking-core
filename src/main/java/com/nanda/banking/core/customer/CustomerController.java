package com.nanda.banking.core.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping
    public List<Customer> index(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id")UUID id){
        return customerService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Customer customer){
        customerService.save(customer);
    }


}

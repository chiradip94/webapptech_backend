package com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Controller;


import com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Model.Customer;
import com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController; 
import java.util.List;

@RestController
public class CustomerController
{
    @Autowired
    CustomerService custService;

    @GetMapping("/customer/count")
    private long getCount()
    {
        return custService.findNoOfCustomer();
    }

    @PostMapping("/customer")
    private Customer saveCustomer(@RequestBody Customer customer)
    {
        return custService.createCustomer(customer);
    }

    @GetMapping("/customers")
    private List<Customer> findAllCustomers()
    {
        return custService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    private Customer findCustomer(@PathVariable("id") long custId)
    {
        return custService.getCustomerById(custId);
    }

    @DeleteMapping("customer/{id}")
    private void deleteCustomer(@PathVariable("id") long custId)
    {
        custService.deleteCustomerById(custId);
    }

    @DeleteMapping("/customers")
    private void deleteCustomers()
    {
        custService.deleteAllCustomers();
    }

    @PutMapping("/customer")
    private Customer updateCustomer(@RequestBody Customer customer)
    {
        return custService.updateCustomer(customer);
    }
}
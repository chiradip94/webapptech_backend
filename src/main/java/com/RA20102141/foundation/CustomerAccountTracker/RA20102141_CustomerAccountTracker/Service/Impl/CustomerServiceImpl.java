package com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Service.Impl;

import com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Model.Customer;
import com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Repository.AccountRepository;
import com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Repository.CustomerRepository;
import com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    CustomerRepository repository;

    //@Autowired
    //AccountRepository accrepository;

    @Override
    public long findNoOfCustomer()
    {
        return(this.repository.count());
    }

    @Override
    public Customer createCustomer(final Customer customer) {
        return repository.save(customer);
        
    }

    @Override
    public List<Customer> getAllCustomers() {
        final List<Customer> customers = new ArrayList<Customer>();
        repository.findAll().forEach(cust -> customers.add(cust));
        return customers;
    }

    @Override
    public Customer getCustomerById(final long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteCustomerById(final long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllCustomers() {
        repository.deleteAll();
    }

    @Override
    public Customer updateCustomer(final Customer customer)
    {
        return repository.save(customer);
    }
}
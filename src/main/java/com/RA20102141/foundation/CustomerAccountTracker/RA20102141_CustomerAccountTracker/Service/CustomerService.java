package com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Service;

import java.util.List;

import com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Model.Customer;

public interface CustomerService
{
    public long findNoOfCustomer();
    public Customer createCustomer(Customer customer);
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(long id);
    public void deleteCustomerById(long id);
    public void deleteAllCustomers();
    public Customer updateCustomer(Customer customer);
}
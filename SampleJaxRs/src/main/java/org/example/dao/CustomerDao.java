package org.example.dao;

import org.example.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer getCustomer(int id);
    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}

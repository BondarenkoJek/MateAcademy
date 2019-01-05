package ua.bondarenkojek.homework.jdbc.service;

import ua.bondarenkojek.homework.jdbc.model.Customer;

public interface CustomerService {
    void addCustomer(Customer customer);

    Customer getCustomer(long id);

    void updateCustomer(Customer customer);

    void deleteCustomer(long id);
}

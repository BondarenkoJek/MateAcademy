package ua.bondarenkojek.homework.jdbc.service.impl;

import ua.bondarenkojek.homework.jdbc.dao.CustomerDao;
import ua.bondarenkojek.homework.jdbc.model.Customer;
import ua.bondarenkojek.homework.jdbc.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomer(long id) {
        return customerDao.getCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerDao.deleteCustomer(id);
    }
}

package xhemil.learn.dao;

import xhemil.learn.model.Customer;

import java.util.List;

public interface CustomerDao {
    boolean addOrUpdateCustomer(Customer customer);

    Customer getCustomer(int id);

    List<Customer> getCustomers(int limit);

    boolean deleteCustomer(int id);
}

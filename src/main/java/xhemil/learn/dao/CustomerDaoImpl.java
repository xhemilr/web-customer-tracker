package xhemil.learn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xhemil.learn.model.Customer;
import xhemil.learn.service.CustomerService;

import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean addOrUpdateCustomer(Customer customer) {
        return customerService.addOrUpdateCustomer(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerService.getCustomer(id);
    }

    @Override
    public List<Customer> getCustomers(int limit) {
        return customerService.getCustomers(limit);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerService.deleteCustomer(id);
    }
}

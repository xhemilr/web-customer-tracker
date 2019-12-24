package xhemil.learn.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xhemil.learn.model.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean addOrUpdateCustomer(Customer customer) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Customer getCustomer(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            return session.get(Customer.class, id);
        }
    }

    @Override
    public List<Customer> getCustomers(int limit) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            return session.createQuery("from Customer").setMaxResults(limit).list();
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(session.get(Customer.class, id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

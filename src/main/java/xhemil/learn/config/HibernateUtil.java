package xhemil.learn.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import xhemil.learn.model.Customer;

@Component
public class HibernateUtil {

    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class).buildSessionFactory();
    }
}

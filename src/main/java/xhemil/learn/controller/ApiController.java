package xhemil.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xhemil.learn.dao.CustomerDao;
import xhemil.learn.model.Customer;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer/api")
public class ApiController {

    @Autowired
    CustomerDao customerDao;

    //http://localhost:8080/customer/api/customer/3
    @GetMapping(path = "/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        Customer customer = customerDao.getCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //http://localhost:8080/customer/api/customer
    @PostMapping(path = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
        boolean inserted = customerDao.addOrUpdateCustomer(customer);
        if (inserted) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(path = "/customer")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
        boolean updated = customerDao.addOrUpdateCustomer(customer);
        if (updated) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(path = "/customer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerDao.deleteCustomer(id);
        return customerDao.deleteCustomer(id) ? "Customer with id " + id + " remove" : "Could not remove customer";
    }

    @GetMapping(path = "/customers")
    public List<Customer> getCustomers(@RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        return customerDao.getCustomers(limit);
    }

}

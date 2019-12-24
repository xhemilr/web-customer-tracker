package xhemil.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xhemil.learn.dao.CustomerDao;
import xhemil.learn.model.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    private String message = "Costumer confirmed";

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/customerDetails")
    public String newCustomer(@RequestParam(name = "id", required = false, defaultValue = "-1") int id, Model model) {
        if (id > 0) {
            model.addAttribute("customer", customerDao.getCustomer(id));
        } else {
            model.addAttribute("customer", new Customer());
        }

        return "customer_details";
    }

    @RequestMapping("processCustomer")
    public String processCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        if (customer != null) {
            if (customer.getId() > 0) {
                message = "Customer details updated";
            } else {
                message = "New Customer added";
            }
            customerDao.addOrUpdateCustomer(customer);
        }
        model.addAttribute("message", message);
        model.addAttribute("customer", customer);
        return "customer_confirmation";
    }

    @RequestMapping("/customerList")
    public String getCustomerList(@RequestParam(value = "limit", defaultValue = "10", required = false) int limit, Model model) {
        List<Customer> customers = customerDao.getCustomers(limit);
        model.addAttribute("customers", customers);
        return "customers";
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") int id) {
        customerDao.deleteCustomer(id);
        return "redirect:/customer/customerList";
    }
}

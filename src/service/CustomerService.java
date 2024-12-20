// CustomerDAO.java
package dao;

import model.Customer;
import java.util.List;

public interface CustomerDAO extends GenericDAO<Customer, Long> {
    Customer findByEmail(String email);
    List<Customer> findByName(String name);
}

// CustomerService.java
package service;

import dao.CustomerDAO;
import model.Customer;
import java.util.List;

public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public boolean addCustomer(Customer customer) {
        if (isValidCustomer(customer)) {
            customerDAO.insert(customer);
            return true;
        }
        return false;
    }

    public boolean updateCustomer(Customer customer) {
        if (customer != null && customer.getId() != null) {
            customerDAO.update(customer);
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(Long id) {
        return customerDAO.delete(id) > 0;
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerDAO.findById(id);
    }

    public Customer getCustomerByEmail(String email) {
        return customerDAO.findByEmail(email);
    }

    public List<Customer> getCustomersByName(String name) {
        return customerDAO.findByName(name);
    }

    private boolean isValidCustomer(Customer customer) {
        return customer != null
            && customer.getName() != null && !customer.getName().isEmpty()
            && customer.getEmail() != null && customer.getEmail().contains("@");
    }
}

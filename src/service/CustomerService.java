package service;

import DAO.CustomerDAO;
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
        if (customer != null && customer.getCustomerId() > 0) {
            customerDAO.update(customer);
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(int customerId) {
        return customerDAO.delete(customerId) > 0;
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomerById(int customerId) {
        return customerDAO.findById(customerId);
    }

    public Customer getCustomerByEmail(String email) {
        return customerDAO.findByEmail(email);
    }

    public List<Customer> getCustomersByName(String name) {
        return customerDAO.findByName(name);
    }

    private boolean isValidCustomer(Customer customer) {
        return customer != null
            && customer.getFirstName() != null && !customer.getFirstName().isEmpty()
            && customer.getLastName() != null && !customer.getLastName().isEmpty()
            && customer.getEmail() != null && customer.getEmail().contains("@");
    }
}

package service;

import DAO.CustomerDAO;
import model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = CustomerDAO.getInstance();
    }

    public boolean addCustomer(Customer customer) {
        if (isValidCustomer(customer)) {
            return customerDAO.insert(customer) > 0;
        }
        return false;
    }

    public boolean updateCustomer(Customer customer) {
        if (isValidCustomer(customer) && customer.getCustomerId() > 0) {
            return customerDAO.update(customer) > 0;
        }
        return false;
    }

    public boolean deleteCustomer(Customer customer) {
        if (customer != null && customer.getCustomerId() > 0) {
            return customerDAO.delete(customer) > 0;
        }
        return false;
    }

    public List<Customer> getAllCustomers() {
        ArrayList<Customer> customers = customerDAO.selectAll();
        return customers != null ? customers : new ArrayList<>();
    }

    public Customer getCustomerById(int customerId) {
        Customer customer = new Customer(customerId, null, null, null, null, null);
        return customerDAO.selectById(customer);
    }

    public Customer getCustomerByEmail(String email) {
        Customer customer = new Customer(0, null, null, email, null, null);
        return customerDAO.selectByEmail(customer);
    }

    public List<Customer> getCustomersByName(String firstName, String lastName) {
        Customer customer = new Customer(0, firstName, lastName, null, null, null);
        ArrayList<Customer> customers = customerDAO.selectByName(customer);
        return customers != null ? customers : new ArrayList<>();
    }

    private boolean isValidCustomer(Customer customer) {
        return customer != null
            && customer.getFirstName() != null && !customer.getFirstName().isEmpty()
            && customer.getLastName() != null && !customer.getLastName().isEmpty()
            && customer.getEmail() != null && customer.getEmail().contains("@");
    }
}

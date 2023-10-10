package service;

import model.Customer;

import java.util.Collection;

public class CustomerService {

    // initialize the only object in CustomerService Singleton class
    private static final CustomerService customerService = new CustomerService();

    // this private constructor prevents the client app
    // from creating the CustomerService class instance
    private CustomerService() {

    }

    public CustomerService getInstance() {
        return customerService;
    }

    public void addCustomer(String email, String firstName, String lastName) {

    }

    public Customer getCustomer(String customerEmail) {
        return null;
    }

    public Collection<Customer> getAllCustomers() {
        return null;
    }
}

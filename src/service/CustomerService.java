package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    // initialize the only object in CustomerService Singleton class
    private static final CustomerService customerService = new CustomerService();
    private final Map<String, Customer> custumers;

    // this private constructor prevents the client app
    // from creating the CustomerService class instance
    private CustomerService() {
        this.custumers = new HashMap<String, Customer>();
    }

    public static CustomerService getInstance() {
        return customerService;
    }

    public void addCustomer(String firstName, String lastName, String email) throws IllegalArgumentException {
        this.custumers.put(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String customerEmail) {
        return this.custumers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        return this.custumers.values();
    }
}

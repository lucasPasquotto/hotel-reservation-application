package model;

import model.Customer;

public class Driver {

    public static void main(String[] args) {
        Customer customer = new Customer("first", "last", "email");
        System.out.println(customer);
    }
}

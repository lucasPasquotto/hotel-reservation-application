package api;

import model.Customer;

public class HotelResource {
    private static final HotelResource hotelResource = new HotelResource();

    private HotelResource() {

    }

    public HotelResource getInstance() {
        return hotelResource;
    }

    public Customer getCustomer(String email) {

    }
}

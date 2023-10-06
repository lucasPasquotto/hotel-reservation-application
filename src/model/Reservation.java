package model;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    private Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation: \n"
                + customer.getFirstName() + " " + customer.getLastName() + "\n"
                + "Room: " + room.getRoomNumber() + " - " + room.getRoomType()
                + "Price: " + room.getRoomPrice() + " price per night"
                + "Checkin: " + checkInDate
                + "Checkout: " + checkOutDate;
    }

}

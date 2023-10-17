package model;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public IRoom getRoom() {
        return this.room;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }

    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation: \n"
                + customer.getFirstName() + " " + customer.getLastName() + "\n"
                + "Room: " + room.getRoomNumber() + " - " + room.getRoomType() + "\n"
                + "Price: " + room.getRoomPrice() + " price per night" + "\n"
                + "Checkin: " + checkInDate + "\n"
                + "Checkout: " + checkOutDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if ((obj == null) || (obj.getClass() != this.getClass()))
            return false;
        Reservation reservation = (Reservation) obj;
        return customer.equals(reservation.customer)
                && room.equals(reservation.room)
                && checkInDate.equals(reservation.checkInDate)
                && checkOutDate.equals(reservation.checkOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, room, checkInDate, checkOutDate);
    }

}

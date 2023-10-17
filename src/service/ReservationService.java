package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReservationService {
    // initialize the only object in CustomerService Singleton class
    private static final ReservationService reservationService = new ReservationService();
    private Map<Customer, Reservation> reservations;
    private Map<String, IRoom> rooms;

    // this private constructor prevents the client app
    // from creating the CustomerService class instance
    private ReservationService() {
        this.reservations = new HashMap<Customer, Reservation>();
        this.rooms = new HashMap<String, IRoom>();
    }

    public ReservationService getInstance() {
        return reservationService;
    }

    public void addRoom(IRoom room){
        this.rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomNumber){
        return this.rooms.get(roomNumber);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        this.reservations.put(customer, reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return null;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        return this.reservations.values()
                .stream()
                .filter(reservation -> reservation.getCustomer().equals(customer))
                .collect(Collectors.toList());
    }

    public void printAllReservation() {
        if (this.reservations.isEmpty()) {
            System.out.println("No reservations");
        } else {
            this.reservations.values().forEach(reservation -> {
                System.out.println(reservation.toString());
            });
        }
    }
}

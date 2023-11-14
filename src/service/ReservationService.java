package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;
import java.util.stream.Collectors;

public class ReservationService {
    // initialize the only object in CustomerService Singleton class
    private static final ReservationService reservationService = new ReservationService();
    private final ArrayList<Reservation> reservations;
    private final Map<String, IRoom> rooms;

    // this private constructor prevents the client app
    // from creating the CustomerService class instance
    private ReservationService() {
        this.reservations = new ArrayList<>();
        this.rooms = new HashMap<String, IRoom>();
    }

    public static ReservationService getInstance() {
        return reservationService;
    }

    public void addRoom(IRoom room){
        this.rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomNumber){
        return this.rooms.get(roomNumber);
    }

    public Collection<IRoom> getAllRooms() {
        return this.rooms.values();
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        this.reservations.add(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> unavailableRooms = new ArrayList<IRoom>();

        for (Reservation reservation : reservations) {
            if (reservation.getCheckInDate().compareTo(checkInDate) >= 0 && checkOutDate.compareTo(reservation.getCheckOutDate()) <= 0) {
                unavailableRooms.add(reservation.getRoom());
            }
        }

        Collection<IRoom> availableRooms = new ArrayList<>(this.rooms.values());
        availableRooms.removeAll(unavailableRooms);

        return availableRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        return this.reservations.stream()
                .filter(reservation -> reservation.getCustomer().equals(customer))
                .collect(Collectors.toList());
    }

    public void printAllReservation() {
        if (this.reservations.isEmpty()) {
            System.out.println("No reservations");
        } else {
            this.reservations.forEach(reservation -> {
                System.out.println(reservation.toString());
            });
        }
    }
}

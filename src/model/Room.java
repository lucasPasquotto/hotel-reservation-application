package model;

import java.util.Objects;

public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    private RoomType type;

    public Room(String roomNumber, Double price, RoomType type) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.type = type;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomType getRoomType() {
        return this.type;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
        return "Room number: " + roomNumber + " Price: $" + price + " Type: " + type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if ((obj == null) || (obj.getClass() != this.getClass()))
            return false;
        Room room = (Room) obj;
        return roomNumber.equals(room.roomNumber) && price.equals(room.price) && type.equals(room.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, price, type);
    }
}

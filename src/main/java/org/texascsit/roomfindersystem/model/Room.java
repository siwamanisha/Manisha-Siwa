package org.texascsit.roomfindersystem.model;

import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
    @SequenceGenerator(name = "room_seq", allocationSize = 1, initialValue = 1, sequenceName = "room_seq")
    private int roomId;
    private String location;
    private double price;
    private boolean availability;
    @ManyToOne
    @JoinColumn(name = "renter_id")
    private Renter renter;


    public Room() {

    }


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public Room(int roomId, String location, double price, boolean availability, Renter renter) {
        this.roomId = roomId;
        this.location = location;
        this.price = price;
        this.availability = availability;
        this.renter = renter;
    }
}


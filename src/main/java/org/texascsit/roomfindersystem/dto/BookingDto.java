package org.texascsit.roomfindersystem.dto;

import org.texascsit.roomfindersystem.model.Booking;
import org.texascsit.roomfindersystem.model.Renter;
import org.texascsit.roomfindersystem.model.Room;

public class BookingDto {
    private Integer roomId;
    private Integer renterId;

    private String location;

    private double price;

    private String renterName;
    private String ownerName;
    public BookingDto() {
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public BookingDto(Booking booking){
        this.renterId=booking.getRenter().getId();
        this.renterName=booking.getRenter().getFullName();
        this.roomId=booking.getRoom().getRoomId();
        this.location=booking.getRoom().getLocation();
        this.price=booking.getRoom().getPrice();
        this.ownerName=booking.getRoom().getRenter().getFullName();
    }

    public BookingDto(Integer roomId, Integer renterId) {
        this.roomId = roomId;
        this.renterId = renterId;
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

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
package org.texascsit.roomfindersystem.dto;

import org.texascsit.roomfindersystem.model.Room;

public class RoomDto {
    private int roomId;
    private String location;
    private double price;

    private boolean availability;
    private Integer renterId;
    public RoomDto() {
    }

    public RoomDto(Room room) {

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

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public RoomDto(int roomId, String location, double price, boolean availability, Integer renterId) {
        this.roomId = roomId;
        this.location = location;
        this.price = price;
        this.availability = availability;
        this.renterId = renterId;
    }

}
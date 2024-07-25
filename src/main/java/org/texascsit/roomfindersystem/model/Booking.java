package org.texascsit.roomfindersystem.model;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "renter_seq")
    @SequenceGenerator(name = "renter_seq", allocationSize = 1, initialValue = 1, sequenceName = "renter_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private Renter renter;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Booking() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Booking(Integer id, Renter renter, Room room) {
        this.id = id;
        this.renter = renter;
        this.room = room;
    }

}
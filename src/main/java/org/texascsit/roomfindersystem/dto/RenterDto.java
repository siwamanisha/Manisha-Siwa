package org.texascsit.roomfindersystem.dto;

import org.texascsit.roomfindersystem.enums.Role;

public class RenterDto {
    private Integer id;
    private String username;
    private String email;
    private String fullName;
    private String address;
    private String password;
    private Role role;
    private Integer phonenumber;

    public RenterDto(Integer id, String username, String email, String fullName, String address, Role role, Integer phonenumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.role = role;
        this.phonenumber = phonenumber;
    }

//    public RenterDto(int roomId, String location, double price, boolean availability) {
//        this.roomId=roomId;
//        this.location=location;
//        this.price=price;
//        this.availability= availability;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public RenterDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public RenterDto(Integer id, String username, String email, String fullName, String address, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.role = role;
    }
}

package org.texascsit.roomfindersystem.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.texascsit.roomfindersystem.enums.Role;

import java.util.Collection;

@Entity
public class Renter  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "renter_seq")
    @SequenceGenerator(name = "renter_seq", allocationSize = 1, initialValue = 1, sequenceName = "renter_seq")
    private Integer id;
    private String username;
    private String email;
    private String fullName;
    private String address;
    private String password;
    private Integer phonenumber;
    @Enumerated(EnumType.STRING)
    private Role role;

    private  boolean accountNonExpired=true;
    private  boolean accountNonLocked=true;
    private  boolean credentialsNonExpired=true;
    private  boolean enabled=true;


    public Renter() {
    }

    public Renter(Integer id, String username, String email, String fullName, String address, String password, Role role, Integer phonenumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.password = password;
        this.role = role;
        this.phonenumber = phonenumber;
    }

    public Renter(Integer id, String username, String email, String fullName, String address, Role role, Integer phonenumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.role = role;
        this.phonenumber = phonenumber;
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

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }


    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}


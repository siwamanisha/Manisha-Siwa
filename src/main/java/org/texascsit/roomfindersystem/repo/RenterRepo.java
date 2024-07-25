package org.texascsit.roomfindersystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.texascsit.roomfindersystem.dto.RoomDto;
import org.texascsit.roomfindersystem.model.Renter;

import java.util.Optional;

public interface RenterRepo extends JpaRepository<Renter, Integer> {


    Optional<Renter> findByUsername(String rentername);
}


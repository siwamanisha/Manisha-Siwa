package org.texascsit.roomfindersystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.texascsit.roomfindersystem.model.Room;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, Integer> {
    @Query(
            nativeQuery = true,
            value = "select * from room where renter_id=?1 ;"
    )

    List<Room> findRoomByRenterId(Integer renterId);
}
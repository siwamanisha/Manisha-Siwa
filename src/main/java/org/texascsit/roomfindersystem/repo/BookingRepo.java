package org.texascsit.roomfindersystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.texascsit.roomfindersystem.model.Booking;
import org.texascsit.roomfindersystem.model.Renter;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {


    @Query(
            nativeQuery = true,
            value = "select * from booking where renter_id=?1 ;"
    )


    List<Booking> findBookingByRenterId(Integer renterId);


}

package org.texascsit.roomfindersystem.service;

import org.texascsit.roomfindersystem.dto.BookingDto;

import java.util.List;

public interface BookingService {
     public String  saveBooking(BookingDto bookingDto);
    List<BookingDto> getBookedListByRenterId (Integer id);

}

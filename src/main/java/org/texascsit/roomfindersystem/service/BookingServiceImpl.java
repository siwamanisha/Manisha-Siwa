package org.texascsit.roomfindersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.texascsit.roomfindersystem.dto.BookingDto;
import org.texascsit.roomfindersystem.exception.ResourceNotFoundException;
import org.texascsit.roomfindersystem.model.Booking;
import org.texascsit.roomfindersystem.model.Renter;
import org.texascsit.roomfindersystem.model.Room;
import org.texascsit.roomfindersystem.repo.BookingRepo;
import org.texascsit.roomfindersystem.repo.RenterRepo;
import org.texascsit.roomfindersystem.repo.RoomRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl  implements BookingService{
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private RenterRepo renterRepo;
    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public String saveBooking(BookingDto bookingDto) {
        Booking booking = new Booking();

        Renter renter = renterRepo.findById(bookingDto.getRenterId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Room room = roomRepo.findById(bookingDto.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        booking.setRenter(renter);
        booking.setRoom(room);
        bookingRepo.save(booking);
        return " saved sucessfully";
    }


    @Override
    public List<BookingDto> getBookedListByRenterId(Integer renterId) {
        List<Booking> bookingList = bookingRepo.findBookingByRenterId(renterId);
        List<BookingDto> bookingDtoList = bookingList.stream()
                .map(booking -> new BookingDto(booking))
                .collect(Collectors.toList());
        return bookingDtoList;
    }
}

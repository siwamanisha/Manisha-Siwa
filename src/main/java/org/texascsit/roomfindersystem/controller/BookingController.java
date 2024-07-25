package org.texascsit.roomfindersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.texascsit.roomfindersystem.dto.BookingDto;
import org.texascsit.roomfindersystem.service.BookingService;

import java.util.List;
@RestController
@RequestMapping("/api/book")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/save")
    public String saveBooking(@RequestBody BookingDto bookingDto){
        bookingService.saveBooking(bookingDto);
        return "Room is booked successfully";
    }

    @GetMapping("/renter-id/{renterId}")
    public List<BookingDto> getBookedListByRenterId(@PathVariable Integer renterId)
    {
        List<BookingDto> bookingDtoList=bookingService.getBookedListByRenterId(renterId);
        return bookingDtoList;
    }




}

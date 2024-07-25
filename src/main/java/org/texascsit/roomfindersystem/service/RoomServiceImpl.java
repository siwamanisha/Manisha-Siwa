package org.texascsit.roomfindersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.texascsit.roomfindersystem.dto.RoomDto;
import org.texascsit.roomfindersystem.exception.ResourceNotFoundException;
import org.texascsit.roomfindersystem.model.Renter;
import org.texascsit.roomfindersystem.model.Room;
import org.texascsit.roomfindersystem.repo.RenterRepo;
import org.texascsit.roomfindersystem.repo.RoomRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private RenterRepo renterRepo;


    @Override
    public void saveRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setAvailability(room.isAvailability());
        room.setLocation(roomDto.getLocation());
        room.setPrice(roomDto.getPrice());
        Renter renter = renterRepo.findById(roomDto.getRenterId())
                .orElseThrow(() -> new ResourceNotFoundException("Renter not found"));
        room.setRenter(renter);
        roomRepo.save(room);
    }

    @Override
    public List<RoomDto> getRoomListByRenterId(Integer renterId) {
        List<Room> roomList = roomRepo.findRoomByRenterId(renterId);
        List<RoomDto> roomDtoList = roomList.stream()
                .map(room -> new RoomDto(room))
                .collect(Collectors.toList());
        return roomDtoList;
    }

    @Override
    public void deleteRoomById(Integer id) {

        roomRepo.deleteById(id);
    }


    @Override
    public String updateRoom(Integer id, RoomDto roomDto) {
        //FETCH DETAILS TO UPDATE
        Integer Id = roomDto.getRenterId();
        Room room = roomRepo.findById(Id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("ROOM NOT FOUND"));
        // UPDATE DETAILS
        room.setPrice(roomDto.getPrice());
        room.setLocation(roomDto.getLocation());
        room.setAvailability(roomDto.isAvailability());
        room.setRoomId(roomDto.getRoomId());
        roomRepo.save(room);
        return "updated";
    }}

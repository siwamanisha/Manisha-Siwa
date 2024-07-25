package org.texascsit.roomfindersystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.texascsit.roomfindersystem.dto.RenterDto;
import org.texascsit.roomfindersystem.dto.RoomDto;
import org.texascsit.roomfindersystem.model.Room;
import org.texascsit.roomfindersystem.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/room")

public class RoomController {
    @Autowired
    private RoomService roomService;
    @PostMapping("/save")
    public String saveRenter(@RequestBody RoomDto roomDto){
        roomService.saveRoom(roomDto);
        return "success";
    }

    @GetMapping("/renter-id/{renterId}")
    public List<RoomDto> getRoomListByRenter(@PathVariable Integer renterId)
    {
        List<RoomDto>roomDtoList=roomService.getRoomListByRenterId(renterId);
        return roomDtoList;
    }

    @PostMapping("/update/{id}")
    public String updateRoom(@PathVariable ("id") Integer id,@RequestBody RoomDto roomDto) {
        roomService.updateRoom(id, roomDto);
        return "Room is updated succesfully";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRoomById(@PathVariable ("id") Integer id )
    {
        roomService.deleteRoomById(id);
        return "Deleted successfully";
    }


}

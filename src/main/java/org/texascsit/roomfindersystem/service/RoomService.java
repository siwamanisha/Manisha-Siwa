package org.texascsit.roomfindersystem.service;

import org.texascsit.roomfindersystem.dto.RoomDto;
import org.texascsit.roomfindersystem.model.Room;

import java.util.List;

public interface RoomService {
    void saveRoom(RoomDto roomDto);
    List<RoomDto> getRoomListByRenterId(Integer renterid);
    void deleteRoomById(Integer id);
    String updateRoom( Integer id, RoomDto roomDto);

}

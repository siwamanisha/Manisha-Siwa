package org.texascsit.roomfindersystem.service;

import org.texascsit.roomfindersystem.dto.RenterDto;

import java.util.List;

public interface RenterService {
public void saveRenter(RenterDto renterDto);
    RenterDto getById(Integer id);

    List<RenterDto>getAllRenters();
    void updateRenter( Integer id , RenterDto renterDto);

    void updateRenter(RenterDto renterDto);

    void deleteRenterById(Integer id);
}

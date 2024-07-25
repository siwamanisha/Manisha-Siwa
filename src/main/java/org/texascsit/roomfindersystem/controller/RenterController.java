package org.texascsit.roomfindersystem.controller;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.texascsit.roomfindersystem.dto.RenterDto;
import org.texascsit.roomfindersystem.service.RenterService;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/renter")
public class RenterController {
 @Autowired
    private RenterService renterService;

    @PostMapping("/save")
    public String saveRenter(@RequestBody RenterDto renterDto) {
        renterService.saveRenter(renterDto);
        return "Renter Saved Successfully";
    }

    @GetMapping("/id/{id}")
    public RenterDto getRenterById(@PathVariable("id") Integer id) {

        return renterService.getById(id);
    }
    @GetMapping("/list")
    public List<RenterDto> getAll(){
        return renterService.getAllRenters();
    }

    @PostMapping("/update/{id}")
    public String updateRenter(@PathVariable ("id") Integer id,@RequestBody RenterDto renterDto) {
         renterService.updateRenter( id, renterDto);
        return "Renter updated is success";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRenterById(@PathVariable ("id") Integer id )
    {
        renterService.deleteRenterById(id);
        return "Deleted successfully";
    }

}

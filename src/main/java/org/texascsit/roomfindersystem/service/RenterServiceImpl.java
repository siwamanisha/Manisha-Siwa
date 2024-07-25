package org.texascsit.roomfindersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.texascsit.roomfindersystem.dto.RenterDto;
import org.texascsit.roomfindersystem.exception.ResourceNotFoundException;
import org.texascsit.roomfindersystem.model.Renter;
import org.texascsit.roomfindersystem.repo.RenterRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RenterServiceImpl implements RenterService {
    @Autowired
    private RenterRepo renterRepo;
    @Autowired

    private PasswordEncoder passwordEncoder;

    public RenterServiceImpl(RenterRepo renterRepo) {

        this.renterRepo = renterRepo;
    }

    @Override
    public void saveRenter(RenterDto renterDto) {
        Renter renter = new Renter();
        renter.setEmail(renterDto.getEmail());
        renter.setAddress(renterDto.getAddress());
        renter.setFullName(renterDto.getFullName());
        renter.setRole(renterDto.getRole());
        renter.setPhonenumber(renterDto.getPhonenumber());
        String rawPassword = passwordEncoder.encode(renterDto.getPassword());
        renter.setPassword(rawPassword);
        renter.setUsername(renterDto.getUsername());
        renterRepo.save(renter);

    }
    public RenterDto getById(Integer id) {
        Optional<Renter> renterOptional = renterRepo.findById(id);
        if (renterOptional.isPresent()) {

            Renter renter = renterOptional.get();
            RenterDto renterDto = new RenterDto();
            renterDto.setEmail(renter.getEmail());
            renterDto.setAddress(renter.getAddress());
            renterDto.setFullName(renter.getFullName());
            renterDto.setRole(renter.getRole());
            renterDto.setPhonenumber(renter.getPhonenumber());
            return renterDto;
        } else {
            throw new RuntimeException(" renter not found");
        }
    }
    public List<RenterDto> getAllRenters() {
        List<Renter> renterList = renterRepo.findAll();
        return renterList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateRenter(Integer id, RenterDto renterDto) {

    }

    @Override
    public void updateRenter(RenterDto renterDto) {
        //FETCH DETAILS TO UPDATE
        Integer id= renterDto.getId();
        Renter renter=renterRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("RENTER NOT FOUND"));
        // UPDATE DETAILS
        renter.setEmail(renterDto.getEmail());
        renter.setAddress(renterDto.getAddress());
        renter.setFullName(renterDto.getFullName());
        renter.setRole(renterDto.getRole());
        renter.setPhonenumber(renterDto.getPhonenumber());

        renter.setPassword(renterDto.getPassword());
        renter.setUsername(renterDto.getUsername());
        renterRepo.save(renter);
    }

    @Override
    public void deleteRenterById(Integer id) {

        renterRepo.deleteById(id);
    }

    private RenterDto convertToDto ( Renter renter)
    {
        if (renter == null)
        {
            return null;
        }
        return  new RenterDto(
                renter.getId(),
                renter.getAddress(),
                renter.getFullName(),
                renter.getUsername(),
                renter.getEmail(),
                renter.getRole(),
                renter.getPhonenumber()

        );
    }
}

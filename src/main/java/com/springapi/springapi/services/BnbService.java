package com.springapi.springapi.services;

import com.springapi.springapi.models.Bnb;
import com.springapi.springapi.repositories.BnbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BnbService {
    @Autowired
    private BnbRepository bnbRepository;

    //Add a bnb
    public Bnb saveBnb(Bnb bnb){
        return bnbRepository.save(bnb);
    }

    //Get All Bnbs
    public List<Bnb> getBnbs(){
        return bnbRepository.findAll();
    }

    //Get Bnb By Id
    public Bnb getBnbById(Integer id){
        return bnbRepository.findById(id).orElse(null);
    }

    //Get Bnb By Location
    public List<Bnb> getBnbByLocation(String location){
        return bnbRepository.findByLocation(location);
    }

    //Delete Product
    public String deleteBnb(int id){
        bnbRepository.deleteById(id);
        return "Bnb Removed";
    }

    //Update product
    public Bnb updateBnb(Bnb bnb){
        Bnb existingBnb = bnbRepository.findById(bnb.getId()).orElse(null);
        existingBnb.setName(bnb.getName());
        existingBnb.setLocation(bnb.getLocation());
        existingBnb.setAvailability(bnb.isAvailability());
        existingBnb.setOwnerContacts(bnb.getOwnerContacts());
        existingBnb.setHouseSize(bnb.getHouseSize());
        existingBnb.setPricePerNight(bnb.getPricePerNight());

        return bnbRepository.save(existingBnb);
    }
}

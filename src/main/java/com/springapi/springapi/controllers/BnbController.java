package com.springapi.springapi.controllers;

import com.springapi.springapi.models.Bnb;
import com.springapi.springapi.services.BnbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BnbController {
    @Autowired
    private BnbService bnbService;

    @PostMapping("/addBnb")
    public Bnb addBnb(@RequestBody Bnb bnb){
        return bnbService.saveBnb(bnb);
    }
    @GetMapping("/getBnbs")
    public List<Bnb> getBnbs(){
        return bnbService.getBnbs();
    }

    @GetMapping("/getBnbById/{id}")
    public Bnb getBnbById(@PathVariable Integer id) {
        return bnbService.getBnbById(id);
    }

    @GetMapping("/getBnbByLocation/{location}")
    public List<Bnb> getBnbByLocation(@PathVariable String location){
        return bnbService.getBnbByLocation(location);
    }

    @DeleteMapping("/deleteBnb/{id}")
    public String deleteBnb(@PathVariable int id){
        return bnbService.deleteBnb(id);
    }

    @PutMapping("/updateBnb")
    public Bnb updateBnb(@RequestBody Bnb bnb){
        return bnbService.updateBnb(bnb);
    }

}

package com.springapi.springapi.repositories;

import com.springapi.springapi.models.Bnb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BnbRepository extends JpaRepository<Bnb,Integer> {
    List<Bnb> findByLocation(String location);
}

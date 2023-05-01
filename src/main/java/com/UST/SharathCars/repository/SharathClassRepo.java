package com.UST.SharathCars.repository;

import com.UST.SharathCars.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SharathClassRepo extends JpaRepository<Cars,Integer> {
    List<Cars> findByDate(String date);
}

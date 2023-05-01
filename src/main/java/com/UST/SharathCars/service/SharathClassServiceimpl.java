package com.UST.SharathCars.service;

import com.UST.SharathCars.model.Cars;
import com.UST.SharathCars.repository.SharathClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class SharathClassServiceimpl implements SharathClassService {
    @Autowired
    private SharathClassRepo repo;
    @Override
    public Cars addCar(Cars car) {
        return repo.save(car);
    }

    @Override
    public List<Cars> getallcars() {
        return repo.findAll();
    }

    @Override
    public List<Cars> getdate(String date) {
        return repo.findByDate(date);
    }
}

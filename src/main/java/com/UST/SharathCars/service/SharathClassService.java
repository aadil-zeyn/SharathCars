package com.UST.SharathCars.service;

import com.UST.SharathCars.model.Cars;

import java.util.Date;
import java.util.List;

public interface SharathClassService {
    Cars addCar(Cars car);

    List<Cars> getallcars();

    List<Cars> getdate(String date);
}

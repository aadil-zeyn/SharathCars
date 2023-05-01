package com.UST.SharathCars.controller;

import com.UST.SharathCars.model.Cars;
import com.UST.SharathCars.service.SharathClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/SharathCars")

public class SharathClassController {
    @Autowired
    private SharathClassService service;

    @PostMapping("/add")
    public Cars createCardetails(@RequestBody Cars car){
        return service.addCar(car);
    }
    @GetMapping("/Cars")
    public List<Cars> getCardetails(){
        return service.getallcars();
    }
    @GetMapping("/Cars/{date}")
    public List<Cars> getdates(@PathVariable String date) {
        return service.getdate(date);
    }
}

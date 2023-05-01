package com.UST.SharathCars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cars {
    @Id
    @GeneratedValue

    private int carId;
    private String carName;
    private long price;
    private String brand;
    private String colour;
    private int noofseats;
    private String date;

}

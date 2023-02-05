package com.noxilaman.carcareshop.service;

import com.noxilaman.carcareshop.entity.Car;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.exception.CarException;
import com.noxilaman.carcareshop.model.MCarReq;
import com.noxilaman.carcareshop.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(String licenseCode, String city, String note, Integer carSizeId) throws BaseException {
        if(Objects.isNull(licenseCode)){
            throw CarException.licenseCodeNull();
        }

        if(Objects.isNull(city)){
            throw CarException.cityNull();
        }

        Car car = new Car();
        car.setSlicensecode(licenseCode);
        car.setScity(city);
        car.setSnote(note);
        car.setIcarsize(carSizeId);
        return carRepository.save(car);
    }
}

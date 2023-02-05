package com.noxilaman.carcareshop.service;

import com.noxilaman.carcareshop.entity.CarSize;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.exception.CarSizeException;
import com.noxilaman.carcareshop.repository.CarSizeRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarSizeService {

    private final CarSizeRepository carSizeRepository;

    public CarSizeService(CarSizeRepository carSizeRepository) {
        this.carSizeRepository = carSizeRepository;
    }

    public CarSize create(String name, String desc, String status) throws BaseException {
        if(Objects.isNull(name)){
            throw CarSizeException.nameNull();
        }

        if(Objects.isNull(status)){
            throw CarSizeException.statusNull();
        }

        if(carSizeRepository.existsByname(name)){
            throw CarSizeException.nameCodeDuplication();
        }

        CarSize carSize = new CarSize();
        carSize.setName(name);
        carSize.setDesc(desc);
        carSize.setStatus(status);
        return carSizeRepository.save(carSize);
    }
}

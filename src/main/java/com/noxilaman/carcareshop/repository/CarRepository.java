package com.noxilaman.carcareshop.repository;

import com.noxilaman.carcareshop.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}

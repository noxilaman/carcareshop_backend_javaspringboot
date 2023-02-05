package com.noxilaman.carcareshop.repository;

import com.noxilaman.carcareshop.entity.CarSize;
import org.springframework.data.repository.CrudRepository;

public interface CarSizeRepository extends CrudRepository<CarSize,Integer> {
    boolean existsByname(String name);
}

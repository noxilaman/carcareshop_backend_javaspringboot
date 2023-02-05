package com.noxilaman.carcareshop.mapper;

import com.noxilaman.carcareshop.entity.Car;
import com.noxilaman.carcareshop.model.MCarRes;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Named("toMCarRes")
    MCarRes toMCarRes(Car car);
}

package com.noxilaman.carcareshop.mapper;

import com.noxilaman.carcareshop.entity.CarSize;
import com.noxilaman.carcareshop.model.MCarSizeRes;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CarSizeMapper {
    @Named("toMCarSizeRes")
    MCarSizeRes toMCarSizeRes(CarSize carSize);
}

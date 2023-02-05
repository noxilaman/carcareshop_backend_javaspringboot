package com.noxilaman.carcareshop.business;

import com.noxilaman.carcareshop.entity.CarSize;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.mapper.CarSizeMapper;
import com.noxilaman.carcareshop.model.MCarSizeReq;
import com.noxilaman.carcareshop.model.MCarSizeRes;
import com.noxilaman.carcareshop.service.CarService;
import com.noxilaman.carcareshop.service.CarSizeService;

public class CarSizeBusiness {

    private final CarSizeMapper carSizeMapper;
    private final CarSizeService carSizeService;

    public CarSizeBusiness(CarSizeMapper carSizeMapper, CarSizeService carSizeService) {
        this.carSizeMapper = carSizeMapper;
        this.carSizeService = carSizeService;
    }

    public MCarSizeRes create(MCarSizeReq mCarSizeReq) throws BaseException {
        CarSize carSize = carSizeService.create(mCarSizeReq.getName(), mCarSizeReq.getDesc(), mCarSizeReq.getStatus() );
        return carSizeMapper.toMCarSizeRes(carSize);
    }
}

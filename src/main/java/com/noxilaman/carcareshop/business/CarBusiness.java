package com.noxilaman.carcareshop.business;

import com.noxilaman.carcareshop.entity.Car;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.exception.CarException;
import com.noxilaman.carcareshop.exception.FileException;
import com.noxilaman.carcareshop.mapper.CarMapper;
import com.noxilaman.carcareshop.model.MCarReq;
import com.noxilaman.carcareshop.model.MCarRes;
import com.noxilaman.carcareshop.repository.CarRepository;
import com.noxilaman.carcareshop.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CarBusiness {

    private final CarService carService;
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarBusiness(CarService carService, CarRepository carRepository, CarMapper carMapper){
        this.carService = carService;
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public MCarRes create(MCarReq mcarreq) throws BaseException {
        if (mcarreq == null){
            throw CarException.allNull();
        }
        if(Objects.isNull(mcarreq.getSLicenseCode())){
            throw CarException.licenseCodeNull();
        }

        if(Objects.isNull(mcarreq.getSCity())){
            throw CarException.cityNull();
        }

        Car car = carService.create(mcarreq.getSLicenseCode(),mcarreq.getSCity(),mcarreq.getSNote(),mcarreq.getICarSize());
        return carMapper.toMCarRes(car);
    }

    public MCarReq getCarById(Integer id){
        return new MCarReq();
    }

    public String uploadCarImage(MultipartFile file) throws BaseException{
        if(file == null){
            throw FileException.fileNull();
        }

        if(file.getSize() > (1048576 * 2)){
            throw FileException.fileOVerSize();
        }

        String contentType = file.getContentType();
        if(contentType == null ){
            throw FileException.contentTypeNull();
        }

        List<String>  supportedTypes = Arrays.asList("image/jpeg","image/png");

        if(!supportedTypes.contains(contentType)){
            throw FileException.contentTypeNotAllow();
        }

        return "";
    }
}

package com.noxilaman.carcareshop.business;

import com.noxilaman.carcareshop.entity.Car;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.exception.CarException;
import com.noxilaman.carcareshop.exception.FileException;
import com.noxilaman.carcareshop.model.MCarReq;
import com.noxilaman.carcareshop.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CarBusiness {

    private final CarRepository carRepository;

    public CarBusiness(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public String create(MCarReq mcarreq) throws BaseException {
        if (mcarreq == null){
            throw CarException.allNull();
        }
        if(Objects.isNull(mcarreq.getSLicenseCode())){
            throw CarException.licenseCodeNull();
        }

        if(Objects.isNull(mcarreq.getSCity())){
            throw CarException.cityNull();
        }

        if(carRepository.existsByslicensecode(mcarreq.getSLicenseCode())){
            throw CarException.licenseCodeDuplication();
        }
        Car car = new Car();
        car.setId(null);
        car.setSlicensecode(mcarreq.getSLicenseCode());
        car.setScity(mcarreq.getSCity());
        car.setSnote(mcarreq.getSNote());
        car.setIcarsize(mcarreq.getICarSize());
        carRepository.save(car);
        return "SAVE";
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

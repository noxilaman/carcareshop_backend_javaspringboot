package com.noxilaman.carcareshop.business;

import com.noxilaman.carcareshop.entity.Car;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.exception.CarException;
import com.noxilaman.carcareshop.exception.FileException;
import com.noxilaman.carcareshop.model.MCarReq;
import com.noxilaman.carcareshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CarBusiness {

    @Autowired
    private CarRepository carRepository;

    public String create(MCarReq mcarreq) throws BaseException {
        if (mcarreq == null){
            throw CarException.allNull();
        }
        if(Objects.isNull(mcarreq.getS_license_code())){
            throw CarException.licenseCodeNull();
        }

        if(Objects.isNull(mcarreq.getS_city())){
            throw CarException.cityNull();
        }
        Car car = new Car();
        car.setId(null);
        car.setS_license_code(mcarreq.getS_license_code());
        car.setS_city(mcarreq.getS_city());
        car.setS_note(mcarreq.getS_note());
        car.setI_car_size(mcarreq.getI_car_size());
        carRepository.save(car);
        return "SAVE";
    }

    public MCarReq getCarById(String id){
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

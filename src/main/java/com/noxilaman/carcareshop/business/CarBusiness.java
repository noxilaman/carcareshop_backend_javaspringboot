package com.noxilaman.carcareshop.business;

import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.exception.CarException;
import com.noxilaman.carcareshop.model.MCarReq;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class CarBusiness {
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
        return "";
    }

    public MCarReq getCarById(String id){
        return new MCarReq();
    }
}

package com.noxilaman.carcareshop.api;

import com.noxilaman.carcareshop.business.CarBusiness;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.model.MCarReq;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/car")
public class CarApi {

//    @Autowired
//    private CarBusiness business;

    private final CarBusiness business;

    public CarApi(CarBusiness business) {
        this.business = business;
    }

    @GetMapping
    public MCarReq car(){
        MCarReq res = new MCarReq();
        res.setI_car_size(1);
        res.setS_license_code("etst");
        res.setS_city("asdasd");
        res.setS_note("asdasdasd");
        return res;
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getCarById(@PathVariable("id") String id){
        MCarReq data = business.getCarById(id);
        return ResponseEntity.ok(data.toString());
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody MCarReq req) throws BaseException {

        String result = business.create(req);
            return ResponseEntity.ok(result);


    }
}

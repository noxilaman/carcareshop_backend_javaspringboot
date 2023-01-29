package com.noxilaman.carcareshop.api;

import com.noxilaman.carcareshop.business.CarBusiness;
import com.noxilaman.carcareshop.model.MCarReq;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public String car(@RequestBody MCarReq req){
        String result = business.create(req);
        return result;
    }
}

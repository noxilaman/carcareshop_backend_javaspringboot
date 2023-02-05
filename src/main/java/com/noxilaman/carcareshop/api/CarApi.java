package com.noxilaman.carcareshop.api;

import com.noxilaman.carcareshop.business.CarBusiness;
import com.noxilaman.carcareshop.entity.Car;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.model.MCarReq;
import com.noxilaman.carcareshop.model.MCarRes;
import com.noxilaman.carcareshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/car")
public class CarApi {
    @Autowired
    private CarRepository carRepository;
//    @Autowired
//    private CarBusiness business;

    private final CarBusiness business;

    public CarApi(CarBusiness business) {
        this.business = business;
    }

    @GetMapping
    public MCarReq car(){
        MCarReq res = new MCarReq();
        res.setICarSize(1);
        res.setSLicenseCode("etst");
        res.setSCity("asdasd");
        res.setSNote("asdasdasd");
        return res;
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getCarById(@PathVariable("id") Integer id){
        MCarReq data = business.getCarById(id);
        return ResponseEntity.ok(data.toString());
    }

    @PostMapping("/create")
    public ResponseEntity<MCarRes> create(@RequestBody MCarReq req) throws BaseException {

        MCarRes result = business.create(req);
            return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<String> uploadCarImage(@RequestPart MultipartFile file){
        return ResponseEntity.ok("");
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Car> getAllCars() {
        // This returns a JSON or XML with the users
        return carRepository.findAll();
    }

    @GetMapping(path="/addnew")
    public ResponseEntity<String> newcar() {
        Car car = new Car();
        car.setSlicensecode("asdasd");
        car.setScity("Asdasd");
        car.setSnote("asdasdasd");
        car.setIcarsize(5);
        carRepository.save(car);
        return ResponseEntity.ok("SAVE");
    }
}

package com.noxilaman.carcareshop.exception;

public class CarSizeException extends BaseException {

    public CarSizeException(String code) {
        super("CarSize." + code);
    }

    public static CarSizeException allNull(){
        return new CarSizeException("All.Null");
    }

    public static CarSizeException nameNull(){
        return new CarSizeException("NAme.Null");
    }

    public static CarSizeException statusNull(){
        return new CarSizeException("Status.Null");
    }

    public static CarSizeException nameCodeDuplication(){
        return new CarSizeException("Name.Duplicate");
    }

}

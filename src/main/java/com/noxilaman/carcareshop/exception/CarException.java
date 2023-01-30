package com.noxilaman.carcareshop.exception;

public class CarException extends BaseException {
    public CarException(String code) {
        super("car." + code);
    }

    public static CarException allNull(){
        return new CarException("All.Null");
    }

    public static CarException licenseCodeNull(){
        return new CarException("LicenseCode.Null");
    }

    public static CarException cityNull(){
        return new CarException("City.Null");
    }
}

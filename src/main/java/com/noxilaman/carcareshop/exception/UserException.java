package com.noxilaman.carcareshop.exception;

import com.noxilaman.carcareshop.entity.User;

public class UserException extends BaseException{
    public UserException(String code) {
        super("User." + code);
    }

    public static UserException userNull(){
        return new UserException("Object is null");
    }

    public static UserException emailNull(){
        return new UserException("Email is null");
    }

    public static UserException passwordNull(){
        return new UserException("Password is null");
    }

    public static UserException nameNull(){
        return new UserException("Name is null");
    }

    public static UserException duplicateemail(){
        return new UserException("Email is duplication");
    }

    public static UserException loginFailEmailNotFound(){
        return new UserException("Login Fail1");
    }

    public static UserException loginFailPasswordNotMatch(){
        return new UserException("Login Fail2");
    }

}

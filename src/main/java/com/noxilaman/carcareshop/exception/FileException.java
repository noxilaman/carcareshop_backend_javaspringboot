package com.noxilaman.carcareshop.exception;

public class FileException extends BaseException {

    public FileException(String code) {
        super("File." + code);
    }

    public static FileException fileNull(){
        return new FileException("File Null");
    }

    public static FileException fileOVerSize(){
        return new FileException("File OVerSize");
    }

    public static FileException contentTypeNull(){
        return new FileException("File empty content Type");
    }
    public static FileException contentTypeNotAllow(){
        return new FileException("File content Type Not Allow");
    }

}

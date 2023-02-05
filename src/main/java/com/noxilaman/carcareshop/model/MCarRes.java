package com.noxilaman.carcareshop.model;

import lombok.Data;

@Data
public class MCarRes {
    private Integer id;
    private String sLicenseCode;
    private String sCity;
    private int iCarSize;
    private String sNote;
    private MCarSizeRes mCarSizeRes;
}

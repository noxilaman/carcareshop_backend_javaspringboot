package com.noxilaman.carcareshop.model;

import lombok.Data;

@Data
public class MCarReq {
    private String sLicenseCode;
    private String sCity;
    private int iCarSize;
    private String sNote;
}

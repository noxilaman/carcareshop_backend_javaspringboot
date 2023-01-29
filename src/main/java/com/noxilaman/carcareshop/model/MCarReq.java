package com.noxilaman.carcareshop.model;

import lombok.Data;

@Data
public class MCarReq {
    private String s_license_code;
    private String s_city;
    private int i_car_size;
    private String s_note;
}

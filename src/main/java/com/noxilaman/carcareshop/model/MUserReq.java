package com.noxilaman.carcareshop.model;

import lombok.Data;

@Data
public class MUserReq {
    private String email;
    private String password;
    private String name;
}

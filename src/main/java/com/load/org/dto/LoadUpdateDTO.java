package com.load.org.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LoadUpdateDTO {
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private int noOfTrucks;
    private int weight;
    private String comment="";
    private Date date;
}

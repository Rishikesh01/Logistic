package com.load.org.dto;


import lombok.Data;

import java.util.Date;

@Data
public class LoadDTO {
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String tuckType;
    private int noOfTrucks;
    private int weight;
    private String comment = "";
    private String shipperId;
    private Date date;
}

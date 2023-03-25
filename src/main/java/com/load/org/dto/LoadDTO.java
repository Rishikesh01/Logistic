package com.load.org.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class LoadDTO {
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private int weight;
    private String comment = "";
    private String shipperId;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date date;
}

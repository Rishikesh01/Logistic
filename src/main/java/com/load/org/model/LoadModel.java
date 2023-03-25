package com.load.org.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class LoadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

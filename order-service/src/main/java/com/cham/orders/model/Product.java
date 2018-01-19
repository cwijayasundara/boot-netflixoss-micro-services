package com.cham.orders.model;

/**
 * Created by cwijayasundara on 26/01/2017.
 */
public class Product {

    String id;

    String productName;

    String unitPrice;

    String manufacturer;

    String meterial;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMeterial() {
        return meterial;
    }

    public void setMeterial(String meterial) {
        this.meterial = meterial;
    }
}
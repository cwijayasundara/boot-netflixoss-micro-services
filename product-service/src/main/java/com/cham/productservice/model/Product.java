package com.cham.productservice.model;

/**
 * Created by cwijayasundara on 26/01/2017.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cwijayasundara on 25/01/2017.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id", nullable = false)
    String id;

    @Column(name = "product_name", nullable = false)
    String productName;

    @Column(name = "unit_price", nullable = false)
    String unitPrice;

    @Column(name = "manufacturer", nullable = false)
    String manufacturer;

    @Column(name = "meterial", nullable = false)
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

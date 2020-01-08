package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
public class PowerSupply extends Product{
    private int powerInWatts;
    private String performanceCertificate;
}

package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "processors")
@PrimaryKeyJoinColumn(name = "product_id",referencedColumnName = "id")
@Getter
@Setter
@NoArgsConstructor
public class Processor extends Product{
    @Column(name = "frequency_Ghz")
    private double CpuFrequencyInGhz;
    private double turboClockFrequencyInGhz;
    private String socketType;
    private int numberOfCors;
    private int maxPowerConsumption;

}

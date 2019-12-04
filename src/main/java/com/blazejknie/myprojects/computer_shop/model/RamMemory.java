package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ram_memories")
@Getter
@Setter
@NoArgsConstructor
public class RamMemory extends Product{
    @Column(name = "frequence_ghz")
    private double frequencyInGhz;

    @Column(name = "capacity_GB")
    private int capacityInGB;


}










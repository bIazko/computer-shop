package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
@Table(name = "ram_memories")
public class RAMemory extends Product{
    @Column(name = "frequence_ghz")
    private double frequencyInGhz;

    @Column(name = "capacity_GB")
    private int capacityInGB;
}










package com.blazejknie.myprojects.computer_shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "processors")
@PrimaryKeyJoinColumn(name = "product_id",referencedColumnName = "id")
@Getter
@Setter
@NoArgsConstructor
public class Processor extends Product{
    @Column(name = "frequency_Ghz")
    private double frequencyInGhz;

}

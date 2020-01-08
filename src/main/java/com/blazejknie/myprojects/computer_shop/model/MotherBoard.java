package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "motherboards")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
public class MotherBoard extends Product {
    private String processorSocket;
    private String motherboardChipset;
    private String supportedMemory;
    private int numberOfMemorySocket;

}

package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
public class HardDrive extends Product {
    private String Type;
    private String capacity;
    private String discInterface;
    private int writeSpeed;
    private int readSpeed;
}

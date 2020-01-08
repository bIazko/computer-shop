package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "hard_discs")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "product_id")
public class HddDisc extends HardDrive{
    private String cacheMemoryInGB;
    private int rotationSpeedInRpm;
}

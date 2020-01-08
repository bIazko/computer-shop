package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")

public class GraphicCard extends Product{

    private int memoryCapacityinMB;
    private String chipsetName;
    private String chipsetModel;
    private String connectorType;
    private int coreClockInMhz;
    private int memoryClockInMhz;
}

package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ssd_discs")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "product_id")
public class SsdDisc extends HardDrive {

}

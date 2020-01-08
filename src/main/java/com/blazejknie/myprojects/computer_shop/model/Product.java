package com.blazejknie.myprojects.computer_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String brand;

    @Column
    @NotNull
    private String model;

    @Column
    @NotNull
    private LocalDate registrationDate;

}

package com.ylizma.stockmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "stockmovements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockMovement extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    private WareHouse wareHouse;

    @Enumerated(EnumType.STRING)
    private MovementType movementType;
}
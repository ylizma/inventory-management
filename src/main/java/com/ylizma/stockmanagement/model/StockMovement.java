package com.ylizma.stockmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "stockmovements")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockMovement extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    private Product product;

    @Enumerated(EnumType.STRING)
    private MovementType movementType;
}

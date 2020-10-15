package com.ylizma.stockmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer quantity;

    private String description;

    @Column(unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.EAGER)
    private WareHouse wareHouse;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProductGroup productGroup;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Supplier supplier;
}

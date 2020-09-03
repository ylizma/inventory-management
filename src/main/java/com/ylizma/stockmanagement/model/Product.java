package com.ylizma.stockmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String code;

    private Integer minStock;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private WareHouse wareHouse;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private ProductGroup productGroup;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private Supplier supplier;
}

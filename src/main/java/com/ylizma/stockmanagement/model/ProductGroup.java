package com.ylizma.stockmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "productgroups")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductGroup extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean active;

    @Column(unique = true)
    private String code;
}

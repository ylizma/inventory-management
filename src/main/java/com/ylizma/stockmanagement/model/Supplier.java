package com.ylizma.stockmanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String city;

    private String phone;

    @Column(nullable = true)
    private String fax;

    @JsonProperty("company")
    private String companyID;

    private boolean active;

}

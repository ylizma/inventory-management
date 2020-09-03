package com.ylizma.stockmanagement.domain;

import com.ylizma.stockmanagement.model.ProductGroup;
import com.ylizma.stockmanagement.model.Supplier;
import com.ylizma.stockmanagement.model.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetails {

     String name;

     String description;

     String code;

     Integer minStock;

     WareHouse wareHouse;

     ProductGroup productGroup;

     Supplier supplier;

     Date createdAt;

     Date lastModified;
}

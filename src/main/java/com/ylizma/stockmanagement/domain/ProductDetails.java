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

    Long id;

    String name;

    String description;

    String code;

    Integer quantity;

    WareHouseDetails wareHouse;

    ProductGroupDetails productGroup;

    SupplierDetails supplier;

    Date createdAt;

    Date lastModified;
}

package com.ylizma.stockmanagement.domain;

import com.ylizma.stockmanagement.model.MovementType;
import com.ylizma.stockmanagement.model.Product;
import com.ylizma.stockmanagement.model.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockMovementDetails {

     Long id;

     int quantity;

     String description;

     Product product;

     MovementType movementType;

     Date createdAt;

     Date lastModified;
}

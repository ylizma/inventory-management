package com.ylizma.stockmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WareHouseDetails {

     Long id;

     String name;

     String description;

     Boolean active;

     String city;

     Date createdAt;

     Date lastModified;
}

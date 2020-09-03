package com.ylizma.stockmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierDetails {

     Long id;

     String name;

     String address;

     String city;

     String phone;

     String fax;

     String companyID;

     boolean active;

     Date createdAt;

     Date lastModified;
}

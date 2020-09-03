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
public class ProductGroupDetails {

    String name;

    boolean active;

    String code;

    Date createdAt;

    Date lastModified;
}

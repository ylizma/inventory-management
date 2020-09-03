package com.ylizma.stockmanagement.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseClass {

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date lastModified;
}

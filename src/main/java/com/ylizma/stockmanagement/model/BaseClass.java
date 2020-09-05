package com.ylizma.stockmanagement.model;


import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseClass {

    @Temporal(TemporalType.TIME)
    private Date createdAt;

    @Temporal(TemporalType.TIME)
    private Date lastModified;
}

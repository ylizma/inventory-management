package com.ylizma.stockmanagement.domain;

import com.ylizma.stockmanagement.model.UserApp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleForm {

    private UserApp user;
    private String role;
}

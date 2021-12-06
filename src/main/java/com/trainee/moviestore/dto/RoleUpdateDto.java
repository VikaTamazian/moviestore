package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Role;
import lombok.Data;


/**
 * Implementation of a data transfer object for updating in the database
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleUpdateDto {

    private long id;
    private String name;

    public Role toRole() {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        return role;
    }

    public RoleUpdateDto fromRole(Role role) {
        RoleUpdateDto roleDto = new RoleUpdateDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }
}


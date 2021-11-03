package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Role;
import com.trainee.moviestore.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class RoleDto {

    private long id;
    private String name;
    private Set<User> users;

    public Role toRole() {

        Role role = new Role();
        role.setId(id);
        role.setName(name);
        role.setUsers(users);
        return role;
    }

    public RoleDto fromRole(Role role) {

        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        roleDto.setUsers(role.getUsers());
        return roleDto;
    }
}


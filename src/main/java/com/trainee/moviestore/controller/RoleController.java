package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.Role;
import com.trainee.moviestore.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    final RoleService roleService;

    @GetMapping("/")
    private List<Role> show() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    private Role getRole(@PathVariable("id") long id) {
        return roleService.findById(id);
    }

    @PostMapping("/")
    private Role saveRole(@RequestBody Role role) {
        roleService.create(role);
        return role;
    }

    @PutMapping("/")
    private Role update(@RequestBody Role role) {
        roleService.update(role);
        return role;
    }

    @DeleteMapping("/{id}")
    private void deleteRole(@PathVariable("id") long id) {
        roleService.delete(id);
    }


}

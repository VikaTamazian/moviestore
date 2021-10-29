package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Role;
import com.trainee.moviestore.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements AbstractService<Role, Long> {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role model) {
        return roleRepository.save(model);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    //TODO update as in UserMovieService
    @Override
    public Role findById(Long value) {
        return roleRepository.findById(value).get();
    }

    //TODO update as in UserMovieService
    @Override
    public Role update(Role model) {
        return roleRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        roleRepository.deleteById(value);
    }
}


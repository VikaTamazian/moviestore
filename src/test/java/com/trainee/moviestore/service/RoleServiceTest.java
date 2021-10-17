package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Role;
import com.trainee.moviestore.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @InjectMocks
    private RoleService roleService;
    @Mock
    private RoleRepository roleRepository;

    @Test
    void createTest() {
        Role role = new Role();
        when(roleRepository.save(any(Role.class))).thenReturn(role);
        assertNotNull(roleService.create(role));
        verify(roleRepository, times(1)).save(role);
    }

    @Test
    void findByIdTest() {
        Role role = new Role();
        when(roleRepository.findById(any(Long.class))).thenReturn(Optional.of(role));
        assertEquals(role, roleService.findById(anyLong()));
        verify(roleRepository, times(1)).findById(anyLong());
    }


    @Test
    void getAllTest() {
        Role role1 = new Role();
        Role role2 = new Role();
        List<Role> roles = Arrays.asList(role1, role2);
        when(roleRepository.findAll()).thenReturn(roles);
        assertEquals(2, roleService.getAll().size());
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    void updateTest() {
        Role role = new Role();
        when(roleRepository.save(any(Role.class))).thenReturn(role);
        assertEquals(role, roleService.update(role));
        verify(roleRepository, times(1)).save(role);

    }

    @Test
    void deleteTest() {
        Long id = 2L;
        roleService.delete(id);
        verify(roleRepository, times(1)).deleteById(id);

    }

}
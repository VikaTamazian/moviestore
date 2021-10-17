package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Status;
import com.trainee.moviestore.repository.StatusRepository;
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
class StatusServiceTest {

    @InjectMocks
    private StatusService statusService;
    @Mock
    private StatusRepository statusRepository;

    @Test
    void createTest() {
        Status status = new Status();
        when(statusRepository.save(any(Status.class))).thenReturn(status);
        assertNotNull(statusService.create(status));
        verify(statusRepository, times(1)).save(status);
    }

    @Test
    void findByIdTest() {
        Status status = new Status();
        when(statusRepository.findById(any(Long.class))).thenReturn(Optional.of(status));
        assertEquals(status, statusService.findById(anyLong()));
        verify(statusRepository, times(1)).findById(anyLong());
    }


    @Test
    void getAllTest() {
        Status status1 = new Status();
        Status status2 = new Status();
        List<Status> statuses = Arrays.asList(status1, status2);
        when(statusRepository.findAll()).thenReturn(statuses);
        assertEquals(2, statusService.getAll().size());
        verify(statusRepository, times(1)).findAll();
    }

    @Test
    void updateTest() {
        Status status = new Status();
        when(statusRepository.save(any(Status.class))).thenReturn(status);
        assertEquals(status, statusService.update(status));
        verify(statusRepository, times(1)).save(status);

    }

    @Test
    void deleteTest() {
        Long id = 2L;
        statusService.delete(id);
        verify(statusRepository, times(1)).deleteById(id);

    }

}
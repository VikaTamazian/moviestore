package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Status;
import com.trainee.moviestore.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements AbstractService<Status, Long> {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status create(Status model) {
        return statusRepository.save(model);
    }

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Long value) {
        return statusRepository.findById(value).get();
    }

    @Override
    public Status update(Status model) {
        return statusRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        statusRepository.deleteById(value);
    }
}


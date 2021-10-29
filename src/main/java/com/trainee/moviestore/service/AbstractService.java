package com.trainee.moviestore.service;

import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public interface AbstractService<T, V> {
    T create(T model);

    default List<T> getAll() {
        throw new NotImplementedException();
    }

    T findById(V value);

    T update(T model);

    void delete(V value);
}


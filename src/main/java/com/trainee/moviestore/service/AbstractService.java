package com.trainee.moviestore.service;

import java.util.List;

public interface AbstractService<T, V> {
    T create(T model);

    List<T> getAll();

    T findById(V value);

    T update(T model);

    void delete(V value);
}


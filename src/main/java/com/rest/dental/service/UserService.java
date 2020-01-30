package com.rest.dental.service;

import java.util.List;
import java.util.Optional;

public interface UserService<T,I> {

    Optional<T> get(I id);

    T save(T entity);

    void delete(I id);

    List<T> getAll();
}

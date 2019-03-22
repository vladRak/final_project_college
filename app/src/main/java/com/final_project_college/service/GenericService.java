package com.final_project_college.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

    int numberOfRows();

    List<T> getAllPaginated(int start, int count);

    List<T> getAll();

    Optional<T> get(long id);

    boolean delete(long id);

    boolean delete(T entity);

    T save(T entity);

    T update(T entity);
}

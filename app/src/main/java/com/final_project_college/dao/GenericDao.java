package com.final_project_college.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<K extends Number,T> {

    int numberOfRows();

    List<T> getAllPaginated(int start, int count);

    List<T> getAll();

    Optional<T> get(K id);

    boolean delete(long id);

    boolean delete(T entity);

    Optional<T> save(T entity);

    Optional<T> update(T entity);
}

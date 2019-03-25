package com.final_project_college.service;

import com.final_project_college.exception.DataAccessException;

import java.util.List;

public interface GenericService<T> {

    int numberOfRows() throws DataAccessException;

    List<T> getAllPaginated(int start, int count) throws DataAccessException;

    List<T> getAll() throws DataAccessException;

    T get(long id) throws DataAccessException;

    boolean delete(long id) throws DataAccessException;

    T save(T entity) throws DataAccessException;

    T update(T entity) throws DataAccessException;
}

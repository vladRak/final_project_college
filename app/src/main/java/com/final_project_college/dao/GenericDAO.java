package com.final_project_college.dao;

import com.final_project_college.exception.DataAccessException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {

    int getNumberOfRows() throws DataAccessException;

    List<T> findAllPaginated(int start, int count) throws DataAccessException;

    List<T> findAll() throws DataAccessException;

    Optional<T> getEntityById(long id) throws DataAccessException;

    boolean deleteById(long id) throws DataAccessException;

    T create(T entity) throws DataAccessException;

    T update(T entity) throws DataAccessException;
}

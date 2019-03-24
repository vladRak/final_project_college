package com.final_project_college.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

//    int numberOfRows() throws SQLException;
//
//    List<T> getAllPaginated(int start, int count) throws SQLException;
//
//    List<T> getAll() throws SQLException;
//
//    Optional<T> get(long id) throws SQLException;
//
//    boolean delete(long id) throws SQLException;
//
//    boolean delete(T entity) throws SQLException;
//
//    T save(T entity) throws SQLException;
//
//    T update(T entity) throws SQLException;

    int numberOfRows();

    List<T> getAllPaginated(int start, int count);

    List<T> getAll();

    Optional<T> get(long id);

    boolean delete(long id);

    boolean delete(T entity);

    T save(T entity);

    T update(T entity);
}

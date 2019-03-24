package com.final_project_college.service;

import com.final_project_college.exception.SystemException;

import java.util.List;

public interface GenericService<T> {

    int numberOfRows() throws SystemException;

    List<T> getAllPaginated(int start, int count) throws SystemException;

    List<T> getAll() throws SystemException;

    T get(long id) throws SystemException;

    boolean delete(long id) throws SystemException;

    T save(T entity) throws SystemException;

    T update(T entity) throws SystemException;
}

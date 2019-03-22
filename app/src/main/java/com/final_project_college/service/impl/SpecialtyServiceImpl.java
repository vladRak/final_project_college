package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.Specialty;
import com.final_project_college.service.SpecialtyService;

import java.util.List;
import java.util.Optional;

public class SpecialtyServiceImpl extends AbstractService implements SpecialtyService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<Specialty> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Specialty> getAll() {
        return null;
    }

    @Override
    public Optional<Specialty> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Specialty entity) {
        return false;
    }

    @Override
    public Specialty save(Specialty entity) {
        return null;
    }

    @Override
    public Specialty update(Specialty entity) {
        return null;
    }
}

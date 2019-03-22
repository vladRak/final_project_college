package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.CollegeSpecialty;
import com.final_project_college.service.CollegeSpecialtyService;

import java.util.List;
import java.util.Optional;

public class CollegeSpecialtyServiceImpl extends AbstractService implements CollegeSpecialtyService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<CollegeSpecialty> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<CollegeSpecialty> getAll() {
        return null;
    }

    @Override
    public Optional<CollegeSpecialty> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(CollegeSpecialty entity) {
        return false;
    }

    @Override
    public CollegeSpecialty save(CollegeSpecialty entity) {
        return null;
    }

    @Override
    public CollegeSpecialty update(CollegeSpecialty entity) {
        return null;
    }
}

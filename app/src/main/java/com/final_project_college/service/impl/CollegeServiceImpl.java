package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.College;
import com.final_project_college.service.CollegeService;

import java.util.List;
import java.util.Optional;

public class CollegeServiceImpl extends AbstractService implements CollegeService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<College> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<College> getAll() {
        return null;
    }

    @Override
    public Optional<College> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(College entity) {
        return false;
    }

    @Override
    public College save(College entity) {
        return null;
    }

    @Override
    public College update(College entity) {
        return null;
    }
}

package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.Application;
import com.final_project_college.service.ApplicationService;

import java.util.List;
import java.util.Optional;

public class ApplicationServiceImpl extends AbstractService implements ApplicationService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<Application> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Application> getAll() {
        return null;
    }

    @Override
    public Optional<Application> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Application entity) {
        return false;
    }

    @Override
    public Application save(Application entity) {
        return null;
    }

    @Override
    public Application update(Application entity) {
        return null;
    }
}

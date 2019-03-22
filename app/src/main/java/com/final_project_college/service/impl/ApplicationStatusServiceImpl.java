package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.ApplicationStatus;
import com.final_project_college.service.ApplicationStatusService;

import java.util.List;
import java.util.Optional;

public class ApplicationStatusServiceImpl extends AbstractService implements ApplicationStatusService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<ApplicationStatus> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<ApplicationStatus> getAll() {
        return null;
    }

    @Override
    public Optional<ApplicationStatus> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(ApplicationStatus entity) {
        return false;
    }

    @Override
    public ApplicationStatus save(ApplicationStatus entity) {
        return null;
    }

    @Override
    public ApplicationStatus update(ApplicationStatus entity) {
        return null;
    }
}

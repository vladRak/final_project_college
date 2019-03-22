package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.Applicant;
import com.final_project_college.service.ApplicantService;

import java.util.List;
import java.util.Optional;

public class ApplicantServiceImpl extends AbstractService implements ApplicantService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<Applicant> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Applicant> getAll() {
        return null;
    }

    @Override
    public Optional<Applicant> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Applicant entity) {
        return false;
    }

    @Override
    public Applicant save(Applicant entity) {
        return null;
    }

    @Override
    public Applicant update(Applicant entity) {
        return null;
    }
}

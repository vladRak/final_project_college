package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.SchoolExam;
import com.final_project_college.service.SchoolExamService;

import java.util.List;
import java.util.Optional;

public class SchoolExamServiceImpl extends AbstractService implements SchoolExamService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<SchoolExam> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<SchoolExam> getAll() {
        return null;
    }

    @Override
    public Optional<SchoolExam> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(SchoolExam entity) {
        return false;
    }

    @Override
    public SchoolExam save(SchoolExam entity) {
        return null;
    }

    @Override
    public SchoolExam update(SchoolExam entity) {
        return null;
    }
}

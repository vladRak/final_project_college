package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.EntranceExam;
import com.final_project_college.service.EntranceExamService;

import java.util.List;
import java.util.Optional;

public class EntranceExamServiceImpl extends AbstractService implements EntranceExamService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<EntranceExam> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<EntranceExam> getAll() {
        return null;
    }

    @Override
    public Optional<EntranceExam> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(EntranceExam entity) {
        return false;
    }

    @Override
    public EntranceExam save(EntranceExam entity) {
        return null;
    }

    @Override
    public EntranceExam update(EntranceExam entity) {
        return null;
    }
}

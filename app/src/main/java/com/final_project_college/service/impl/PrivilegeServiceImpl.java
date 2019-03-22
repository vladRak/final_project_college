package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.Privilege;
import com.final_project_college.service.PrivilegeService;

import java.util.List;
import java.util.Optional;

public class PrivilegeServiceImpl extends AbstractService implements PrivilegeService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<Privilege> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Privilege> getAll() {
        return null;
    }

    @Override
    public Optional<Privilege> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Privilege entity) {
        return false;
    }

    @Override
    public Privilege save(Privilege entity) {
        return null;
    }

    @Override
    public Privilege update(Privilege entity) {
        return null;
    }
}

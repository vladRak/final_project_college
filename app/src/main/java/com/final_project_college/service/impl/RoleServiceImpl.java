package com.final_project_college.service.impl;

import com.final_project_college.domain.dto.Role;
import com.final_project_college.service.RoleService;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl extends AbstractService implements RoleService {
    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<Role> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Optional<Role> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Role entity) {
        return false;
    }

    @Override
    public Role save(Role entity) {
        return null;
    }

    @Override
    public Role update(Role entity) {
        return null;
    }
}

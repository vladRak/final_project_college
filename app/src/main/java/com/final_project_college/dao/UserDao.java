package com.final_project_college.dao;

import com.final_project_college.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    Optional<User> getByEmail(String email);

    Optional<User> getByEmailAndPassword(String email, String password);

    Optional<User> getUserByVerificationHash(String hash);

    boolean deleteVerificationHashByUserId(long userId);

    Optional<String> saveVerificationHash(long userId, String hash);

    List<User> getUnverifiedUsersPaginated(int start, int count);

    List<User> getUsersByRoleId(long roleId);

    List<User> getUnverifiedUsersByRoleId(long roleId);

    List<User> getUsersToInvitation(long specialtyId, int governmentOrder);
}

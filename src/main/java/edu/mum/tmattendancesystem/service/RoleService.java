package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.Role;

import java.util.List;

public interface RoleService {

    Role findByName(String role);

    Role findById(long id);

    List<Role> findAll();

}

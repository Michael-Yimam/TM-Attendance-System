package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String role);
    Role findById(long id);

    List<Role> findAll();
}

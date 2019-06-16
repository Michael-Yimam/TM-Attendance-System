package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<User, String> {
}

package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}

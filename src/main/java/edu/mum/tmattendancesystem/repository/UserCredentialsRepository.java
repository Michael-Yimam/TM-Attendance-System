package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.UserCredentials;
import org.springframework.data.repository.CrudRepository;

public interface UserCredentialsRepository extends CrudRepository<UserCredentials, String> {

}

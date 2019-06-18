package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

public interface UserCredentialsRepository extends CrudRepository<UserCredentials, String> {
    //@Query("select u from User_credentials where u.user_id =?1")
    UserCredentials findByUserName(String userName);

}

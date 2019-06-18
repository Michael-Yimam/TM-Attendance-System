package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.UserCredentials;

public interface UserCredentialsService {

    UserCredentials findByUserName(String userName);

    UserCredentials saveUserCredentials(UserCredentials userCredentials);

}

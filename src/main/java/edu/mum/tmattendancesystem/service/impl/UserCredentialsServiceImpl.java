package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.Role;
import edu.mum.tmattendancesystem.domain.UserCredentials;
import edu.mum.tmattendancesystem.repository.RoleRepository;
import edu.mum.tmattendancesystem.repository.UserCredentialsRepository;
import edu.mum.tmattendancesystem.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@Service
@Transactional
public class UserCredentialsServiceImpl implements UserCredentialsService {

    @Autowired
    private UserCredentialsRepository credentialsRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserCredentials findByUserName(String userName) {

        return credentialsRepository.findByUserName(userName);
    }

    public UserCredentials saveUserCredentials(UserCredentials credentials) {
        credentials.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));
        credentials.setActive(1);
        //Role userRole = roleRepository.findByName("ADMIN");
        //credentials.setRoles(new HashSet<Role>(Arrays.asList(userRole)));;
        return credentialsRepository.save(credentials);
    }

}

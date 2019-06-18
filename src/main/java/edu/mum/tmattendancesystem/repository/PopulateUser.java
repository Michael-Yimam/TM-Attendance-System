package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class  PopulateUser implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    private UserCredentialsRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PopulateUser(UserCredentialsRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        userRepository.save(new UserCredentials("admin", bCryptPasswordEncoder.encode("12345"), "ADMIN", 1));
        userRepository.save(new UserCredentials("tina11", bCryptPasswordEncoder.encode("12345"), "FACULTY", 1));
        userRepository.save(new UserCredentials("asad11", bCryptPasswordEncoder.encode("12345"), "FACULTY", 1));
        userRepository.save(new UserCredentials("9869", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9870", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9871", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9860", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9880", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9845", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9861", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9862", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9863", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9875", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9881", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
        userRepository.save(new UserCredentials("9889", bCryptPasswordEncoder.encode("12345"), "STUDENT", 1));
    }
}

package org.scaler.bms5thmay.Service;


import org.scaler.bms5thmay.Repo.UserRepository;
import org.scaler.bms5thmay.models.User;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(String email, String Password, String name){

        /*
            1. check if user already exist with given email..
            2. if yes ask user to login..
            3. if not create new user object if any validation do that before..
            4. save it db...
         */


        // TODO: check if user already exist...
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(Password);

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(encryptedPassword);
        return userRepository.save(u);
    }

    public User login(String email, String password){

        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            throw  new RuntimeException("email is not present..");
        }

        User u = userOptional.get();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(bCryptPasswordEncoder.matches(password,u.getPassword())){
            return u;
        }
        throw  new RuntimeException("invalid password");

    }
}

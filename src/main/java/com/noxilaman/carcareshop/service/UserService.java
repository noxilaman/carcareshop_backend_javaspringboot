package com.noxilaman.carcareshop.service;

import com.noxilaman.carcareshop.entity.User;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.exception.UserException;
import com.noxilaman.carcareshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(String email, String password, String name) throws BaseException {
        if(Objects.isNull(email)){
            throw UserException.emailNull();
        }

        if(Objects.isNull(password)){
            throw UserException.passwordNull();
        }

        if(Objects.isNull(name)){
            throw UserException.nameNull();
        }

        if(userRepository.existsByemail(email)){
            throw UserException.duplicateemail();
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean matchPassword(String rwPassword, String encodePass){
        return passwordEncoder.matches(rwPassword, encodePass);
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public User updateName(Integer id,String name) throws UserException {
        Optional<User> opt = userRepository.findById(id);
        if(!opt.isPresent()){
            throw UserException.loginFailEmailNotFound();
        }

        User user = opt.get();
        user.setName(name);
        return userRepository.save(user);
    }

    public boolean deleteByEmail(String email) throws UserException {
        Optional<User> opt = userRepository.findByEmail(email);
        if(!opt.isPresent()){
            throw UserException.loginFailEmailNotFound();
        }
        User user = opt.get();
        userRepository.delete(user);
        return true;
    }

    public Iterable<User> getAllUsers() throws UserException{
        return userRepository.findAll();
    }

}

package com.RestAPISecuritiToken.service.impl;

import com.RestAPISecuritiToken.model.Role;
import com.RestAPISecuritiToken.model.Status;
import com.RestAPISecuritiToken.model.User;
import com.RestAPISecuritiToken.repository.RoleRepository;
import com.RestAPISecuritiToken.repository.UserRepository;
import com.RestAPISecuritiToken.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {

        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        user.setEmail(user.getEmail());
         userRepository.save(user);

        System.out.println("IN register - user: "+ user +" successfully registered");

        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        System.out.println("IN getAll - "+ result.size() +" users found");
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        System.out.println("IN findByUsername - user: "+ result +" found by username: " + username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {

            System.out.println("IN findById - no user found by id: "+ id);
            return null;
        }

        System.out.println("IN findById - user:  found by id:  "+ result);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

        System.out.println("IN delete - user with id: "+ userRepository.findById(id) +" successfully deleted");
    }
}

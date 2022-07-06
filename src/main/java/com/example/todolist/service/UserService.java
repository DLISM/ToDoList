package com.example.todolist.service;

import com.example.todolist.domain.Role;
import com.example.todolist.domain.User;
import com.example.todolist.repository.UserRepo;
import com.example.todolist.util.UpdatePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public boolean addUser(User user) {

        User userFromDB = userRepo.findByUsername(user.getUsername());
        if(userFromDB!=null){
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        mailSender.send(user.getEmail(), "Spring приложения", "Сообщения с текстом");

        return true;
    }

    public User update(User userFromDB, User user) {

        userFromDB.setUsername(user.getUsername());
        userFromDB.setEmail(user.getEmail());

        return userRepo.save(userFromDB);
    }

    public boolean updatePassword(User userFromDB, UpdatePassword updatePassword) {

        if(updatePassword.getNewPassword().equals(updatePassword.getNewPasswordConfirmed())){
            userFromDB.setPassword(passwordEncoder.encode(updatePassword.getNewPassword()));
            userRepo.save(userFromDB);
            return true;
        }
        return false;
    }
}

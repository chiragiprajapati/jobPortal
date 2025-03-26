package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.Users;
import com.jobPortal.jobPortal.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public Users registerUser(Users user) {
        user.setUserStatus(true);
        user.setUserRegiDate(new Date(System.currentTimeMillis()));
        return userRepository.save(user);
    }
}

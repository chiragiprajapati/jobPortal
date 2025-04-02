package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.Users;
import org.apache.catalina.User;

import java.util.Optional;

public interface UserService {

    Users registerUser(Users users);
    Optional<Users> getUserByEmail(String UserEmail);

    Object getCurrentUserProfile();

    Users getCurrentUseer();

    Users findByEmail(String currentUsername);
}

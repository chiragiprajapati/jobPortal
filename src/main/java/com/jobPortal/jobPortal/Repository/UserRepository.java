package com.jobPortal.jobPortal.Repository;

import com.jobPortal.jobPortal.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users ,Integer> {
    Optional<Users> findByUserEmail (String UserEmail);
}

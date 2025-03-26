package com.jobPortal.jobPortal.Repository;

import com.jobPortal.jobPortal.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users ,Integer> {
}

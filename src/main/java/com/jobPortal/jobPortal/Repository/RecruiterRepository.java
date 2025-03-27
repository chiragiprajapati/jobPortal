package com.jobPortal.jobPortal.Repository;

import com.jobPortal.jobPortal.Model.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<RecruiterProfile,Integer> {
}

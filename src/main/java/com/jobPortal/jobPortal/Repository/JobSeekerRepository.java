package com.jobPortal.jobPortal.Repository;

import com.jobPortal.jobPortal.Model.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeekerProfile, Integer> {
}

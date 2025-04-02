package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.JobSeekerProfile;

import java.util.Optional;

public interface JobSeekerProfileService {
    Optional<JobSeekerProfile> getOne(int userId);
}

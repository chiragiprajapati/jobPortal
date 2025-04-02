package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.RecruiterProfile;
import jakarta.validation.Valid;

import java.util.Optional;

public interface RecruiterProfileService {

    Optional<RecruiterProfile> getOne(Integer id);

    RecruiterProfile addNew( RecruiterProfile recruiterProfile);

    RecruiterProfile getCurrentRecruiterProfile();
}

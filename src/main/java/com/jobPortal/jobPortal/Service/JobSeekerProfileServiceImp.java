package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.JobSeekerProfile;
import com.jobPortal.jobPortal.Repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobSeekerProfileServiceImp implements JobSeekerProfileService{

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Override
    public Optional<JobSeekerProfile> getOne(int userId) {
        return jobSeekerRepository.findById(userId);
    }
}

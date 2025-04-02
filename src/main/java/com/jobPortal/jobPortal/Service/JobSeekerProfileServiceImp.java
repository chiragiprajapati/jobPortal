package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.JobSeekerProfile;
import com.jobPortal.jobPortal.Model.Users;
import com.jobPortal.jobPortal.Repository.JobSeekerRepository;
import com.jobPortal.jobPortal.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobSeekerProfileServiceImp implements JobSeekerProfileService{

    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<JobSeekerProfile> getOne(int userId) {
        return jobSeekerRepository.findById(userId);
    }

    @Override
    public JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile) {
        return jobSeekerRepository.save(jobSeekerProfile);
    }

    @Override
    public JobSeekerProfile getCurrentSeekerProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            Users users = userRepository.findByUserEmail(currentUsername).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            Optional<JobSeekerProfile> seekerProfile = getOne(users.getUserId());
            return seekerProfile.orElse(null);
        } else return null;

    }
    }


package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.JobSeekerProfile;
import com.jobPortal.jobPortal.Model.RecruiterProfile;
import com.jobPortal.jobPortal.Model.UserType;
import com.jobPortal.jobPortal.Model.Users;
import com.jobPortal.jobPortal.Repository.JobSeekerRepository;
import com.jobPortal.jobPortal.Repository.RecruiterRepository;
import com.jobPortal.jobPortal.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecruiterRepository recruiterRepository;
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;


    @Override
    public Users registerUser(Users user) {
        user.setUserStatus(true);
        user.setUserRegiDate(new Date(System.currentTimeMillis()));
        user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
        int userType = user.getUserType().getUserType();
        Users savedUser = userRepository.save(user);
        if(userType == 1){
            RecruiterProfile recruiterProfile = new RecruiterProfile();
            recruiterProfile.setUserId(savedUser);
            recruiterRepository.save(recruiterProfile);
        }else{
            JobSeekerProfile jobSeekerProfile = new JobSeekerProfile();
            jobSeekerProfile.setUserId(savedUser);
            jobSeekerRepository.save(jobSeekerProfile);
        }
        return savedUser;
    }

    @Override
    public Optional<Users> getUserByEmail(String UserEmail) {
        return userRepository.findByUserEmail(UserEmail);
    }

    @Override
    public Object getCurrentUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            Users users = userRepository.findByUserEmail(username).orElseThrow(()-> new UsernameNotFoundException("Could not found " + "user"));
            int userId = users.getUserId();
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))) {
                RecruiterProfile recruiterProfile = recruiterRepository.findById(userId).orElse(new RecruiterProfile());
                return recruiterProfile;
            } else {
                JobSeekerProfile jobSeekerProfile = jobSeekerRepository.findById(userId).orElse(new JobSeekerProfile());
                return jobSeekerProfile;
            }
        }

        return null;
    }
}

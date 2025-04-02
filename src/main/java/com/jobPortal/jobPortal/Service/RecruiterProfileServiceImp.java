package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.RecruiterProfile;
import com.jobPortal.jobPortal.Repository.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecruiterProfileServiceImp implements RecruiterProfileService{

   @Autowired
   private RecruiterRepository recruiterRepository;

    @Override
    public Optional<RecruiterProfile> getOne(Integer id) {
        return recruiterRepository.findById(id);
    }

    @Override
    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
        return recruiterRepository.save(recruiterProfile);
    }
}

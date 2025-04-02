package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.JobPostActivity;
import com.jobPortal.jobPortal.Model.JobSeekerProfile;
import com.jobPortal.jobPortal.Model.JobSeekerSave;
import com.jobPortal.jobPortal.Repository.JobSeekerSaveRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class JobSeekerSaveServiceImp implements JobSeekerSaveService{

    @Autowired
    private JobSeekerSaveRepository jobSeekerSaveRepository;

    @Override
    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId) {
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    @Override
    public List<JobSeekerSave> getJobCandidates(JobPostActivity job) {
        return jobSeekerSaveRepository.findByJob(job);
    }

    @Override
    public void addNew(JobSeekerSave jobSeekerSave) {
        jobSeekerSaveRepository.save(jobSeekerSave);
    }
}

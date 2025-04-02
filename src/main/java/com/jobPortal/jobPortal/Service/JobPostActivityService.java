package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.JobPostActivity;
import com.jobPortal.jobPortal.Model.RecruiterJobsDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobPostActivityService {

    JobPostActivity addNew(JobPostActivity jobPostActivity);
    List<RecruiterJobsDto> getRecruiterJobs(int recruiter);

    JobPostActivity getOne(int id);
}

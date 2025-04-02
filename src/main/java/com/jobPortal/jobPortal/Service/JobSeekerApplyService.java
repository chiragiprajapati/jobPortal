package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.JobPostActivity;
import com.jobPortal.jobPortal.Model.JobSeekerApply;
import com.jobPortal.jobPortal.Model.JobSeekerProfile;

import java.util.List;

public interface JobSeekerApplyService {
    List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId);
    List<JobSeekerApply> getJobCandidates(JobPostActivity job);
    void addNew(JobSeekerApply jobSeekerApply);
}

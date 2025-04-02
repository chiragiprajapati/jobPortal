package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.JobPostActivity;
import com.jobPortal.jobPortal.Model.JobSeekerProfile;
import com.jobPortal.jobPortal.Model.JobSeekerSave;

import java.util.List;

public interface JobSeekerSaveService {
    List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId);
    List<JobSeekerSave> getJobCandidates(JobPostActivity job);

    void addNew(JobSeekerSave jobSeekerSave);
}

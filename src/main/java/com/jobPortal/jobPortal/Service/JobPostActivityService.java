package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.JobPostActivity;
import com.jobPortal.jobPortal.Model.RecruiterJobsDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface JobPostActivityService {

    JobPostActivity addNew(JobPostActivity jobPostActivity);
    List<RecruiterJobsDto> getRecruiterJobs(int recruiter);

    JobPostActivity getOne(int id);

    List<JobPostActivity> getAll();

    List<JobPostActivity> search(String job, String location, List<String> list, List<String> list1, LocalDate searchDate);
}

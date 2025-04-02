package com.jobPortal.jobPortal.Controller;

import com.jobPortal.jobPortal.Model.JobPostActivity;
import com.jobPortal.jobPortal.Service.JobPostActivityService;
import com.jobPortal.jobPortal.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class JobSeekerApplyController {

    @Autowired
    private JobPostActivityService jobPostActivityService;
    @Autowired
    private UserService userService;

    @GetMapping("job-details-apply/{id}")
    public String display(@PathVariable("id") int id, Model model) {
        JobPostActivity jobDetails = jobPostActivityService.getOne(id);

        model.addAttribute("jobDetails", jobDetails);
        model.addAttribute("user", userService.getCurrentUserProfile());
        return "job-details";
    }
}

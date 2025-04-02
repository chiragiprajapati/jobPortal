package com.jobPortal.jobPortal.Controller;

import com.jobPortal.jobPortal.Model.RecruiterProfile;
import com.jobPortal.jobPortal.Model.Users;
import com.jobPortal.jobPortal.Repository.UserRepository;
import com.jobPortal.jobPortal.Service.RecruiterProfileService;
import com.jobPortal.jobPortal.util.FileUploadUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/recruiter-profile")
@RequiredArgsConstructor
public class RecruiterProfileController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecruiterProfileService recruiterProfileService;

    @GetMapping("/")
    public String recrutierProfile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            Users users = userRepository.findByUserEmail(currentUsername).orElseThrow(() -> new UsernameNotFoundException("Could not " + "found user"));
            Optional<RecruiterProfile> recruiterProfile = recruiterProfileService.getOne(users.getUserId());

            if (!recruiterProfile.isEmpty())
                model.addAttribute("profile", recruiterProfile.get());

        }

        return "recruiter_profile";
    }

    @PostMapping("/addNew")
    public String addNew(@Valid RecruiterProfile recruiterProfile, @RequestParam("image") MultipartFile multipartFile, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            Users users = userRepository.findByUserEmail(currentUsername).orElseThrow(() -> new UsernameNotFoundException("Could not " + "found user"));
            recruiterProfile.setUserId(users);
            recruiterProfile.setUserAccountId(users.getUserId());
        }
        model.addAttribute("profile", recruiterProfile);
        String fileName = "";
        if (!multipartFile.getOriginalFilename().equals("")) {
            fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            recruiterProfile.setProfilePhoto(fileName);
        }
        RecruiterProfile savedUser = recruiterProfileService.addNew(recruiterProfile);

        String uploadDir = "photos/recruiter/" + savedUser.getUserAccountId();
        try {
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "redirect:/dashboard/";
    }
    }


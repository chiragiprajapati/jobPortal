package com.jobPortal.jobPortal.Controller;

import com.jobPortal.jobPortal.Model.UserType;
import com.jobPortal.jobPortal.Model.Users;
import com.jobPortal.jobPortal.Service.UserService;
import com.jobPortal.jobPortal.Service.UserTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsersController {

    @Autowired
    private UserTypeService userTypeService;
    @Autowired
    private UserService userService;

//    @GetMapping("/userType")
//    public List<UserType> getAllUserType(){
//        return userTypeService.getUserTypeList();
//    }

    @GetMapping("/register")
    public String Register(Model model){

        List<UserType> userTypes = userTypeService.getUserTypeList();
        model.addAttribute("getAllTypes",userTypes);
        model.addAttribute("user",new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration( @Valid Users user){
        userService.registerUser(user);
        return "dashboard";
    }
}

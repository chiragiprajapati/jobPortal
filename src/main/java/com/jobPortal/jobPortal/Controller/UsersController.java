package com.jobPortal.jobPortal.Controller;

import com.jobPortal.jobPortal.Model.UserType;
import com.jobPortal.jobPortal.Model.Users;
import com.jobPortal.jobPortal.Service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UserTypeService userTypeService;

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
}

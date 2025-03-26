package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.UserType;
import com.jobPortal.jobPortal.Model.Users;
import com.jobPortal.jobPortal.Repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImp implements UserTypeService{

    @Autowired
    private UserTypeRepository userTypeRepository;


    @Override
    public List<UserType> getUserTypeList() {
        return userTypeRepository.findAll();
    }
}

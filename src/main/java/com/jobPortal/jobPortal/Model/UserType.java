package com.jobPortal.jobPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "users_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserType {

    @Column(name = "user_type_id")
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int userType;

    @Column (name = "user_type_name")
    private String userTypeName;

    @OneToMany (targetEntity = Users.class,cascade = CascadeType.ALL, mappedBy = "userType")
    private List<Users> user;

}

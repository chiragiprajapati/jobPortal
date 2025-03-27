package com.jobPortal.jobPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table (name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Column (name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column (name = "email" , unique = true)
    private String userEmail;

    @Column (name = "is_active")
    private Boolean userStatus;

    @NonNull
    @Column (name = "password")
    private String userPwd;

    @DateTimeFormat (pattern = "dd-MM-yyyy")
    @Column (name = "registration_date")
    private Date userRegiDate;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "user_type_id", referencedColumnName = "user_type_id")
    private UserType userType;

}

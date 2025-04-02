package com.jobPortal.jobPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recruiter_profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruiterProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    @Column (name = "city")
    private String city;

    @Column (name = "company")
    private String company;

    @Column (name = "country")
    private String country;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "profile_photo" , nullable = true, length = 64)
    private String profilePhoto;

    @Column (name = "state")
    private String state;

    @Transient
    public String getPhotosImagePath() {
        if (profilePhoto == null) return null;
        return "/photos/recruiter/" + userAccountId + "/" + profilePhoto;
    }
}

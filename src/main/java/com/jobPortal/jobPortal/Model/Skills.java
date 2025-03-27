package com.jobPortal.jobPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "name")
    private String name;

    @Column(name = "years_of_experience")
    private String yearsOfExperience;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "job_seeker_profile")
    private JobSeekerProfile jobSeekerProfile;

}

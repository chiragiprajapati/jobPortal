package com.jobPortal.jobPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "job_post_activity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_post_id")
    private int jobPostId;

    @Column(name = "description_of_job")
    @Length(max = 10000)
    private String descriptionOfJob;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_type")
    private String jobType;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "posted_date")
    private Date postedDate;

    private String remote;

    private String salary;

    @Transient
    private Boolean isActive;

    @Transient
    private Boolean isSaved;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobCompanyId", referencedColumnName = "Id")
    private JobCompany jobCompanyId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobLocationId", referencedColumnName = "Id")
    private JobLocation jobLocationId;

    @ManyToOne
    @JoinColumn(name = "postedById", referencedColumnName = "user_id")
    private Users postedById;
}

package com.Recruiting.IJP.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Job_Requisition")
public class JobRequisition {
    @Id
    @Column(name = "jobreq_id")
    @GeneratedValue
    private long JobReqId;
    private String title;
    private int m_level;
    @OneToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "worker_id")
    private Worker Manager;
    @ManyToMany(mappedBy = "jobreqs")
    @JsonManagedReference(value = "jr_skills")
    @JsonIgnore
    private Set<Skill> skills;
    @OneToMany(mappedBy = "jobReq", cascade = CascadeType.ALL)
    //@JoinColumn(name = "worker_id" , referencedColumnName = "worker_id")
    @JsonIgnore
    private Set<JobApplication> jobApplications;

    public Set<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(Set<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    public long getJobReqId() {
        return JobReqId;
    }

    public void setJobReqId(long jobReqId) {
        JobReqId = jobReqId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getM_level() {
        return m_level;
    }

    public void setM_level(int m_level) {
        this.m_level = m_level;
    }

    public Worker getManager() {
        return Manager;
    }

    public void setManager(Worker manager) {
        Manager = manager;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}

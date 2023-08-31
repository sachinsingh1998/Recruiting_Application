package com.Recruiting.IJP.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Candidate")
public class Candidate {
    @Id
    @Column(name = "candidate_id")
    @GeneratedValue
    private long candidateId;
    private int no_of_applications;
    @OneToOne()
    @JoinColumn(name = "worker_id", referencedColumnName = "worker_id", unique = true)
    private Worker worker;
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    //@JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id")
    @JsonIgnore
    private Set<JobApplication> jobApplications;
    public Candidate(){}

    public Set<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(Set<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    public Candidate(Worker worker) {
        super();
        this.no_of_applications=0;
        this.worker=worker;
    }

    public long getcandidateId() {
        return candidateId;
    }

    public void setcandidateId(long c_id) {
        this.candidateId = c_id;
    }

    public int getNo_of_applications() {
        return no_of_applications;
    }

    public void setNo_of_applications(int no_of_applications) {
        this.no_of_applications = no_of_applications;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}

package com.Recruiting.IJP.model;

import com.Recruiting.IJP.Id.JobApplicationId;

import javax.persistence.*;

@Entity
@Table(name = "Job_Application")
public class JobApplication {
    @EmbeddedId
    private JobApplicationId jid;
    @ManyToOne
    @MapsId("candidateId")
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @ManyToOne
    @MapsId("JobReqId")
    @JoinColumn(name = "jobreq_id")
    private JobRequisition jobReq;
    private String status;

    public JobApplicationId getJid() {
        return jid;
    }

    public void setJid(JobApplicationId jid) {
        this.jid = jid;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public JobRequisition getJobReq() {
        return jobReq;
    }

    public void setJobReq(JobRequisition jobReq) {
        this.jobReq = jobReq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

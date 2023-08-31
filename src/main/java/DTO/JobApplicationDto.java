package DTO;

import com.Recruiting.IJP.Id.JobApplicationId;
import com.Recruiting.IJP.model.JobApplication;

public class JobApplicationDto {
    private JobApplicationId jid;
    private long candidateId;
    private String candidateName;
    private long jobReqId;
    private String jrName;
    private String status;
    public JobApplicationDto(JobApplication jobApplication){
        jid=jobApplication.getJid();
        candidateId=jobApplication.getCandidate().getcandidateId();
        candidateName=jobApplication.getCandidate().getWorker().getName();
        jobReqId=jobApplication.getJobReq().getJobReqId();
        jrName=jobApplication.getJobReq().getTitle();
        status=jobApplication.getStatus();
    }

    /*public JobApplicationId getJid() {
        return jid;
    }

    public void setJid(JobApplicationId jid) {
        this.jid = jid;
    }*/

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public long getJobReqId() {
        return jobReqId;
    }

    public void setJobReqId(long jobReqId) {
        this.jobReqId = jobReqId;
    }

    public String getJrName() {
        return jrName;
    }

    public void setJrName(String jrName) {
        this.jrName = jrName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.Recruiting.IJP.Id;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JobApplicationId implements Serializable {
    private long candidateId;
    private long JobReqId;
    public JobApplicationId(){}
    public JobApplicationId(long candidateId, long jobReqId) {
        this.candidateId = candidateId;
        JobReqId = jobReqId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobApplicationId that = (JobApplicationId) o;
        return candidateId == that.candidateId && JobReqId == that.JobReqId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId, JobReqId);
    }
}

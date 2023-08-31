package com.Recruiting.IJP.repository;

import com.Recruiting.IJP.model.Candidate;
import com.Recruiting.IJP.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
    Worker findWorkerByCandidateId(long id);
}

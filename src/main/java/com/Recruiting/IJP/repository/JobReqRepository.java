package com.Recruiting.IJP.repository;

import com.Recruiting.IJP.model.JobRequisition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobReqRepository extends JpaRepository<JobRequisition,Long> {
}

package com.Recruiting.IJP.repository;

import com.Recruiting.IJP.Id.JobApplicationId;
import com.Recruiting.IJP.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, JobApplicationId> {
}

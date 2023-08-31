package com.Recruiting.IJP.service;

import DTO.JobApplicationDto;
import com.Recruiting.IJP.Exception.EntityNotFoundException;
import com.Recruiting.IJP.Exception.ReRegisteredException;
import com.Recruiting.IJP.Id.JobApplicationId;
import com.Recruiting.IJP.model.Candidate;
import com.Recruiting.IJP.model.JobApplication;
import com.Recruiting.IJP.model.JobRequisition;
import com.Recruiting.IJP.repository.CandidateRepository;
import com.Recruiting.IJP.repository.JobApplicationRepository;
import com.Recruiting.IJP.repository.JobReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobApplicationService {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    @Autowired
    private JobReqRepository jobReqRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    public JobApplication createNewJA(Long c_id,Long jr_id){
        //System.out.println("Check 1");
        JobApplicationId jid = new JobApplicationId(c_id,jr_id);
        //System.out.println("Check 2");
        if(jobApplicationRepository.existsById(jid)){
            throw new ReRegisteredException(c_id);
        }

        Candidate candidate = candidateRepository.findById(c_id)
                .orElseThrow(()->new EntityNotFoundException(c_id));
        JobRequisition jobRequisition = jobReqRepository.findById(jr_id)
                .orElseThrow(()->new EntityNotFoundException(jr_id));
        //System.out.println("Check 3 "+jid);
        JobApplication jobApplication = new JobApplication();
        jobApplication.setJid(jid);
        jobApplication.setCandidate(candidate);
        jobApplication.setJobReq(jobRequisition);
        jobApplication.setStatus("Screen");
        //System.out.println("Check 4");
        //candidate.getJobApplications().add(jobApplication);
        //jobRequisition.getJobApplications().add(jobApplication);
        //System.out.println("Check 5 ");
        System.out.println(jobApplication.getJid());
        return jobApplicationRepository.save(jobApplication);
    }
    public List<JobApplicationDto> getAllApllications(){
        List<JobApplication> jobApplications= jobApplicationRepository.findAll();
        return jobApplications.stream()
                .map(jobApplication -> {
                    JobApplicationDto jobApplicationDto = new JobApplicationDto(jobApplication);
                    return jobApplicationDto;
                })
                .collect(Collectors.toList());
    }
    public JobApplicationDto getSpecificApplication(Long c_id,Long jr_id){
        JobApplicationId jid = new JobApplicationId(c_id,jr_id);
        return new JobApplicationDto(jobApplicationRepository.findById(jid)
                .orElseThrow(()->new EntityNotFoundException(69L)));
    }
    public JobApplicationDto changeStatus(Long c_id,Long jr_id,String newStatus){
        JobApplicationId jid = new JobApplicationId(c_id,jr_id);
        JobApplication jobApplication = jobApplicationRepository.findById(jid)
                .orElseThrow(()->new EntityNotFoundException(69L));
        jobApplication.setStatus(newStatus);
        return new JobApplicationDto(jobApplicationRepository.save(jobApplication));
    }
}

package com.Recruiting.IJP.service;

import DTO.JobApplicationDto;
import DTO.JobRequisitionDTO;
import com.Recruiting.IJP.Exception.EntityNotFoundException;
import com.Recruiting.IJP.Exception.ReRegisteredException;
import com.Recruiting.IJP.model.*;
import com.Recruiting.IJP.repository.CandidateRepository;
import com.Recruiting.IJP.repository.JobReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private JobReqRepository jobReqRepository;
    public Candidate addCandidate(long id){
        if(WorkerHasCandidateProfile(id)){
            //System.out.println("Worker already registered");
            throw new ReRegisteredException(id);
        }

        Candidate newCandidate = new Candidate(
                workerService.getWorkersById(id)
        );
        return candidateRepository.save(newCandidate);
    }
    public List<Candidate> getCandidates(){
        return candidateRepository.findAll();
    }
    public Candidate getCandidateById(Long id){
        return candidateRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(id));
    }
    public Worker getWorker(Long id){
        return getCandidateById(id).getWorker();
    }
    //check if the given worker id has a corresponding candidate id
    private boolean WorkerHasCandidateProfile(long id){
        List<Candidate> candidates=getCandidates();
        for(Candidate candidate:candidates){
            if(candidate.getWorker().getworkerId() == id)
                return true;
        }
        return false;
    }
    public List<JobRequisitionDTO> getMatchingReq(long id){
        Worker worker = getWorker(id);
        List<JobRequisition> jrs = jobReqRepository.findAll();
        List<JobRequisitionDTO> matchingJr = new ArrayList<>();
        for(JobRequisition jr : jrs){
            Set<Skill> workerSkills = worker.getSkills();
            Set<Skill> jobreqSkills = jr.getSkills();
            if(jobreqSkills.stream().anyMatch(workerSkills::contains)){
                matchingJr.add(new JobRequisitionDTO(jr.getJobReqId(),jr.getTitle(),jr.getM_level(),jr.getManager().getName(),jobreqSkills));
            }
        }
        return matchingJr;
    }
    public List<JobRequisitionDTO> getDifferentReq(long id){
        Worker worker = getWorker(id);
        List<JobRequisition> jrs = jobReqRepository.findAll();
        List<JobRequisitionDTO> differentJr = new ArrayList<>();
        for(JobRequisition jr : jrs){
            Set<Skill> workerSkills = worker.getSkills();
            Set<Skill> jobreqSkills = jr.getSkills();
            if(! jobreqSkills.stream().anyMatch(workerSkills::contains)){
                differentJr.add(new JobRequisitionDTO(jr.getJobReqId(),jr.getTitle(),jr.getM_level(),jr.getManager().getName(),jobreqSkills));
            }
        }
        return differentJr;
    }
    public List<JobApplicationDto> getCandidateApplication(Long c_id){
        Set<JobApplication> jobApplications = candidateRepository.findById(c_id)
                .orElseThrow(()->new EntityNotFoundException(c_id))
                .getJobApplications();
        return jobApplications.stream()
                .map(jobApplication -> {
                    JobApplicationDto jobApplicationDto = new JobApplicationDto(jobApplication);
                    return jobApplicationDto;
                }).collect(Collectors.toList());
    }
}

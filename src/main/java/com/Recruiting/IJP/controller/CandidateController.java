package com.Recruiting.IJP.controller;

import DTO.JobApplicationDto;
import DTO.JobRequisitionDTO;
import com.Recruiting.IJP.model.Candidate;
import com.Recruiting.IJP.model.JobApplication;
import com.Recruiting.IJP.model.JobRequisition;
import com.Recruiting.IJP.model.Worker;
import com.Recruiting.IJP.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ijp/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @PostMapping("/register/{id}")
    Candidate registerUser(@PathVariable Long id){
        return candidateService.addCandidate(id);
    }
    @GetMapping("/getAll")
    List<Candidate> getAllCandidates(){
        return candidateService.getCandidates();
    }
    @GetMapping("/getSpecific/{id}")
    Candidate getCandidate(@PathVariable long id){
        return candidateService.getCandidateById(id);
    }
    @GetMapping("/getWorker/{id}")
    Worker getWorkerFromCandidate(@PathVariable long id){
        return candidateService.getCandidateById(id).getWorker();
    }
    @GetMapping("/getRelevantJr/{id}")
    List<JobRequisitionDTO> getRelevantJr(@PathVariable long id){
        return candidateService.getMatchingReq(id);
    }
    @GetMapping("/getDifferentJr/{id}")
    List<JobRequisitionDTO> getDifferentJr(@PathVariable long id){
        return  candidateService.getDifferentReq(id);
    }
    @GetMapping("/getJa/{id}")
    List<JobApplicationDto> getJaByCandidate(@PathVariable long id){
        return candidateService.getCandidateApplication(id);
    }
}

package com.Recruiting.IJP.controller;

import DTO.JobApplicationDto;
import com.Recruiting.IJP.Id.JobApplicationId;
import com.Recruiting.IJP.model.JobApplication;
import com.Recruiting.IJP.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ijp/ja")
public class JobApplicationController {
    @Autowired
    private JobApplicationService jobApplicationService;
    @PostMapping("/add")
    JobApplication addNewJa(@RequestBody Map<String,Long> payload){
        return jobApplicationService.createNewJA(payload.get("c_id"),payload.get("req_id"));
    }
    @GetMapping("/getAll")
    List<JobApplicationDto> getAllJa(){
        return jobApplicationService.getAllApllications();
    }
    @GetMapping("/GetSpecific")
    JobApplicationDto getSpecificApplication(@RequestBody Map<String,Long> payload){
        return jobApplicationService.getSpecificApplication(payload.get("candidateId"),
                payload.get("JobReqId") );
    }
    @PutMapping("/changeStatus/{status}")
    JobApplicationDto changeStatus(@RequestBody Map<String,Long> payload, @PathVariable String status){
        return jobApplicationService.changeStatus(payload.get("candidateId"),
                payload.get("JobReqId"),status);
    }

}

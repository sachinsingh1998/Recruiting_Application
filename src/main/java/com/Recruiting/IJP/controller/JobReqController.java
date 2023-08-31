package com.Recruiting.IJP.controller;

import DTO.JobApplicationDto;
import DTO.JobRequisitionDTO;
import com.Recruiting.IJP.model.JobRequisition;
import com.Recruiting.IJP.service.JobReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ijp/jr")
public class JobReqController {
    @Autowired
    private JobReqService jobReqService;
    @PostMapping("/add")
    private JobRequisition addJR(@RequestBody JobRequisition newJR){
        return jobReqService.addJR(newJR);
    }
    @GetMapping("/getAll")
    private List<JobRequisitionDTO> getAllJRs(){
        return jobReqService.getAllJRDTO();
    }
    @GetMapping("/getSpecific/{id}")
    private JobRequisitionDTO getSpecificJr(@PathVariable Long id){
        return jobReqService.getJrDTOById(id);
    }
    @PostMapping("/associateManager")
    private JobRequisition associateManager(@RequestBody Map<String,Long> payload){
        return jobReqService.associateManager(payload.get("jr_id"),payload.get("manager_id"));
    }
    @GetMapping("/getReqsByManager/{m_id}")
    private List<JobRequisition> getReqByManagers(@PathVariable Long m_id){
        return jobReqService.getReqByManagerId(m_id);
    }
    @PostMapping("/addSkill")
    private JobRequisition addSkill(@RequestBody Map<String,Long> payload){
        return jobReqService.addSkill(payload.get("jr_id"),payload.get("skill_id"));
    }
    @GetMapping("/getJa/{id}")
    private List<JobApplicationDto> getJobAppByJr(@PathVariable long id){
        return jobReqService.getJrApplication(id);
    }


}

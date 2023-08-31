package com.Recruiting.IJP.service;

import DTO.JobApplicationDto;
import DTO.JobRequisitionDTO;
import com.Recruiting.IJP.Exception.EntityNotFoundException;
import com.Recruiting.IJP.model.JobApplication;
import com.Recruiting.IJP.model.JobRequisition;
import com.Recruiting.IJP.model.Skill;
import com.Recruiting.IJP.repository.JobReqRepository;
import com.Recruiting.IJP.repository.SkillRepository;
import com.Recruiting.IJP.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobReqService {
    @Autowired
    private JobReqRepository jobReqRepository;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private SkillRepository skillRepository;
    public String test(){
        return "Fuck you@!!";
    }
    public JobRequisition addJR(JobRequisition newJobReq){
        return jobReqRepository.save(newJobReq);
    }
    public List<JobRequisition> getAllJR(){
        /*return jobReqRepository.findAll()
                .stream().map(jr -> {
                    jr.getTitle();
                })*/
        return jobReqRepository.findAll();
    }
    public List<JobRequisitionDTO> getAllJRDTO(){
        List<JobRequisition> jrs = getAllJR();
        return jrs.stream()
                .map(jr ->{
                    JobRequisitionDTO dto = new JobRequisitionDTO();
                    dto.setJobReqId(jr.getJobReqId());
                    dto.setM_level(jr.getM_level());
                    dto.setTitle(jr.getTitle());
                    dto.setManagerName(jr.getManager().getName());
                    dto.setSkillNames(jr.getSkills().stream().map(Skill::getSkillName).collect(Collectors.toSet()));
                    return dto;
                })
                .collect(Collectors.toList());
    }
    public JobRequisition getJrById(Long jr_id){
        return jobReqRepository.findById(jr_id)
                .orElseThrow(()->new EntityNotFoundException(jr_id));
    }
    public JobRequisitionDTO getJrDTOById(Long jr_id){
        JobRequisition jr = jobReqRepository.findById(jr_id)
                .orElseThrow(()->new EntityNotFoundException(jr_id));
        JobRequisitionDTO dto = new JobRequisitionDTO();
        dto.setJobReqId(jr.getJobReqId());
        dto.setM_level(jr.getM_level());
        dto.setTitle(jr.getTitle());
        dto.setManagerName(jr.getManager().getName());
        dto.setSkillNames(jr.getSkills().stream().map(Skill::getSkillName).collect(Collectors.toSet()));
        return dto;
    }
    public JobRequisition associateManager(Long jr_id, Long w_id){
        JobRequisition jr = getJrById(jr_id);
        jr.setManager(
                workerService.getWorkersById(w_id)
        );
        return jobReqRepository.save(jr);
    }
    public JobRequisition addSkill(long jr_id,long s_id){
        JobRequisition jr = getJrById(jr_id);
        Skill skill = skillRepository.findById(s_id)
                .orElseThrow(()->new EntityNotFoundException(s_id));
        jr.getSkills().add(skill);
        skill.getJobreqs().add(jr);
        return jobReqRepository.save(jr);
    }
    public List<JobRequisition> getReqByManagerId(Long m_id) {
        return getAllJR().stream()
                .filter(jr -> jr.getManager().getworkerId() == m_id)
                .collect(Collectors.toList());
    }
    public List<JobApplicationDto> getJrApplication(long id){
        Set<JobApplication> jobApplications = jobReqRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(id))
                .getJobApplications();
        return jobApplications.stream().map(
                jobApplication -> {
                    JobApplicationDto jobApplicationDto = new JobApplicationDto(jobApplication);
                    return jobApplicationDto;
                }
        ).collect(Collectors.toList());
    }

}

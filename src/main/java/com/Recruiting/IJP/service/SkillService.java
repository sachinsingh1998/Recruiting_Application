package com.Recruiting.IJP.service;

import com.Recruiting.IJP.Exception.EntityNotFoundException;
import com.Recruiting.IJP.model.Skill;
import com.Recruiting.IJP.model.Worker;
import com.Recruiting.IJP.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;
    public Skill addSkill(String skill){
        return skillRepository.save(new Skill(skill));
    }
    public List<Skill> getSkills(){
        return skillRepository.findAll();
    }
    public Set<Worker> getWorkerBySkillId(Long skill_id){
        return skillRepository.findById(skill_id)
                .orElseThrow(()->new EntityNotFoundException(skill_id))
                .getWorkers();
    }
}

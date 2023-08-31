package com.Recruiting.IJP.controller;

import com.Recruiting.IJP.model.Skill;
import com.Recruiting.IJP.model.Worker;
import com.Recruiting.IJP.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ijp/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @PostMapping("/add/{sname}")
    Skill addSkill(@PathVariable String sname){
        return skillService.addSkill(sname);
    }
    @GetMapping("/getAll")
    List<Skill> getSkills(){
        return skillService.getSkills();
    }
    @GetMapping("/getWorkers/{skill_id}")
    public Set<Worker> getWorkerBySkills(@PathVariable Long skill_id){
        return skillService.getWorkerBySkillId(skill_id);
    }
}

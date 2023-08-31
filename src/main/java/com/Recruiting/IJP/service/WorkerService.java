package com.Recruiting.IJP.service;

import com.Recruiting.IJP.Exception.EntityNotFoundException;
import com.Recruiting.IJP.model.Skill;
import com.Recruiting.IJP.model.Worker;
import com.Recruiting.IJP.repository.SkillRepository;
import com.Recruiting.IJP.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private SkillRepository skillRepository;
    public Worker addWorker(Worker newWorker){
        return workerRepository.save(newWorker);
    }
    public List<Worker> getWorkers(){
        return workerRepository.findAll();
    }
    public Worker getWorkersById(Long id){
        return workerRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(id));
    }
    public Worker addSkills(Long worker_id, Long skill_id){
        Worker worker = workerRepository.findById(worker_id)
                .orElseThrow(()->new EntityNotFoundException(worker_id));
        Skill skill = skillRepository.findById(skill_id)
                .orElseThrow(()->new EntityNotFoundException(skill_id));
        worker.getSkills().add(skill);
        skill.getWorkers().add(worker);
        return workerRepository.save(worker);
    }
}

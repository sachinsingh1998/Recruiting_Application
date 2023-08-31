package com.Recruiting.IJP.controller;

import com.Recruiting.IJP.model.Worker;
import com.Recruiting.IJP.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ijp/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @PostMapping("/add")
    Worker addWorker(@RequestBody Worker newWorker){
        return workerService.addWorker(newWorker);
    }
    @GetMapping("/getAll")
    List<Worker> getAllWorkers(){
        return workerService.getWorkers();
    }
    @GetMapping("/getSpecific/{id}")
    Worker getWorkerById(@PathVariable Long id){
        return workerService.getWorkersById(id);
    }
    @PostMapping("/addSkill")
    Worker addSkills(@RequestBody Map<String,Long> payload){
       return workerService.addSkills(payload.get("worker_id"),payload.get("skill_id"));
    }
}

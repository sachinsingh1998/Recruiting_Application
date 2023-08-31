package com.Recruiting.IJP.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Skill")
public class Skill {
    @Id
    @GeneratedValue
    @Column(name = "skill_id")
    private long skillId;
    private String skillName;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "worker_skills",
    joinColumns = @JoinColumn(name = "skill_id"),
    inverseJoinColumns = @JoinColumn(name = "worker_id"))
    @JsonBackReference(value = "worker_skills")
    private Set<Worker> workers;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "req_skills",
    joinColumns = @JoinColumn(name = "skill_id"),
    inverseJoinColumns = @JoinColumn(name = "jobreq_id"))
    @JsonBackReference(value = "jr_skills")
    private Set<JobRequisition> jobreqs;

    public Set<JobRequisition> getJobreqs() {
        return jobreqs;
    }

    public void setJobreqs(Set<JobRequisition> jobreqs) {
        this.jobreqs = jobreqs;
    }

    public Skill(){

    }
    public Skill(String skillName) {
        super();
        this.skillName=skillName;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
}

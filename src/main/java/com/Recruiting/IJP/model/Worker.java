package com.Recruiting.IJP.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue
    @Column(name = "worker_id")
    private long workerId;
    private String name;
    private int m_level;
    @ManyToMany(mappedBy = "workers")
    @JsonManagedReference(value = "worker_skills")
    @JsonIgnore
    private Set<Skill> skills;

    public Set<Skill> getSkills() {
        return skills;
    }
    public void addSkills(Skill skill){
        skills.add(skill);
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public long getworkerId() {
        return workerId;
    }

    public void setworkerId(long w_id) {
        this.workerId = w_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getM_level() {
        return m_level;
    }

    public void setM_level(int m_level) {
        this.m_level = m_level;
    }
}

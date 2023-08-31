package DTO;

import com.Recruiting.IJP.model.Skill;

import java.util.Set;
import java.util.stream.Collectors;

public class JobRequisitionDTO {
    private long JobReqId;
    private String title;
    private int m_level;
    private String managerName;
    private Set<String> SkillNames;
    public JobRequisitionDTO(){

    }
    public JobRequisitionDTO(long jobReqId, String title, int m_level, String managerName, Set<Skill> skill) {
        super();
        JobReqId = jobReqId;
        this.title = title;
        this.m_level = m_level;
        this.managerName = managerName;
        SkillNames = skill.stream().map(Skill::getSkillName).collect(Collectors.toSet());
    }

    public long getJobReqId() {
        return JobReqId;
    }

    public void setJobReqId(long jobReqId) {
        JobReqId = jobReqId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getM_level() {
        return m_level;
    }

    public void setM_level(int m_level) {
        this.m_level = m_level;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<String> getSkillNames() {
        return SkillNames;
    }

    public void setSkillNames(Set<String> skillNames) {
        SkillNames = skillNames;
    }

    @Override
    public String toString() {
        return "JobRequisitionDTO{" +
                "JobReqId=" + JobReqId +
                ", title='" + title + '\'' +
                ", m_level=" + m_level +
                ", manager='" + managerName + '\'' +
                ", Skills=" + SkillNames +
                '}';
    }
}

package org.example.capstone2.Repository;

import org.example.capstone2.Model.TeamLead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamLeadRepository extends JpaRepository<TeamLead, Integer> {
    TeamLead findTeamLeadByID (Integer Id);

    List<TeamLead> findTeamLeadByExperienceAfter(Integer experience);
}

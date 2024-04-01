package org.example.capstone2.Service;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiException;
import org.example.capstone2.Model.TeamLead;
import org.example.capstone2.Model.User;
import org.example.capstone2.Repository.TeamLeadRepository;
import org.example.capstone2.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamLeadService {
    private final TeamLeadRepository teamLeadRepository;
    private final UserRepository userRepository;
    public List<TeamLead> getAll(){
        return teamLeadRepository.findAll();
    }

    public void addTeamLead(TeamLead teamLead){
        teamLeadRepository.save(teamLead);
    }
    public void updateTeamLead(Integer Id , TeamLead teamLead) {

        TeamLead tl = teamLeadRepository.findTeamLeadByID(Id);

        if (tl == null) {
            throw new ApiException("Invalid Id");
        }

        tl.setEmail(teamLead.getEmail());
        tl.setName(teamLead.getName());
        tl.setStatus(teamLead.getStatus());
        tl.setExperience(teamLead.getExperience());
        teamLeadRepository.save(tl);
    }


    public void deleteTeamLead(Integer Id ) {

        TeamLead tl = teamLeadRepository.findTeamLeadByID(Id);

        if (tl == null) {
            throw new ApiException("Invalid Id");
        }
        teamLeadRepository.delete(tl);
    }

    public List<TeamLead>getExperienceAbove(Integer experience){
        List<TeamLead>tl = teamLeadRepository.findTeamLeadByExperienceAfter(experience);
        if(tl==null){
            throw new ApiException("Invalid weight");
        }
        return tl;
    }

    public void statusUpdate(Integer id){
        TeamLead tl = teamLeadRepository.findTeamLeadByID(id);

        if (tl == null) {
            throw new ApiException("Invalid Id");
        }

        if(tl.getExperience()>10){
            tl.setStatus("pro");
        }
        else{
            tl.setStatus("beginner");
        }

    }

}

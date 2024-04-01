package org.example.capstone2.Service;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiException;
import org.example.capstone2.Model.*;
import org.example.capstone2.Repository.MatchhRepository;
import org.example.capstone2.Repository.TeamLeadRepository;
import org.example.capstone2.Repository.TeamRepository;
import org.example.capstone2.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final TeamLeadRepository teamLeadRepository;
    private final MatchhRepository matchhRepository;


    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    public void addTeam(Team team ){
        TeamLead tl = teamLeadRepository.findTeamLeadByID(team.getTeamleadID());
        if (tl == null) {
            throw new ApiException("Invalid Id");
        }
        teamRepository.save(team);
    }
    public void updateTeam(Integer Id , Team team) {

        Team t = teamRepository.findTeamByID(Id);

        if (t == null) {
            throw new ApiException("Invalid Id");
        }

//        t.setCapacity(team.getCapacity());
        t.setName(team.getName());
        teamRepository.save(t);
    }


    public void deleteTeam(Integer Id ) {

        Team t = teamRepository.findTeamByID(Id);

        if (t == null) {
            throw new ApiException("Invalid Id");
        }
        teamRepository.delete(t);
    }

 public String joinTeam(Integer teamID , Integer userID){
     Team t = teamRepository.findTeamByID(teamID);
     User u = userRepository.findUserByID(userID);
     if (t == null || u ==null) {
         throw new ApiException("Invalid Team/User Id");
     }

return ("User with id "+ userID + " added to team");

 }

 public Team findByName(String name){
     Team t = teamRepository.findTeamByName(name);

     if (t == null) {
         throw new ApiException("Invalid Team name");
     }

     return t;
 }





}

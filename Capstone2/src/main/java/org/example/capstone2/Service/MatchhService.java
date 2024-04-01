package org.example.capstone2.Service;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiException;
import org.example.capstone2.Model.Matchh;
import org.example.capstone2.Model.Organizer;
import org.example.capstone2.Model.Team;
import org.example.capstone2.Repository.MatchhRepository;
import org.example.capstone2.Repository.OrganizerRepository;
import org.example.capstone2.Repository.TeamRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchhService {
    private final MatchhRepository matchhrepository;
    private final OrganizerRepository organizerRepository;
    private final TeamRepository teamRepository;

    public List<Matchh> getAll(){
        return  matchhrepository.findAll();
    }

    public void addMatchh(Matchh Matchh){
        Organizer o = organizerRepository.findOrganizerByID(Matchh.getOrganizerID());
        Team t = teamRepository.findTeamByID(Matchh.getTeamID());
        if (o == null || t==null) {
            throw new ApiException("Invalid Id");
        }
           matchhrepository.save(Matchh);
    }
    public void updateMatchh(Integer Id , Matchh Matchh) {

        Matchh m = matchhrepository.findMatchhById(Id);

        if (m == null) {
            throw new ApiException("Invalid Id");
        }

//        m.setTime(Matchh.getTime());
        m.setLocation(Matchh.getLocation());
//        m.setStartDate(Matchh.getStartDate());
//        m.setEndDate(Matchh.getEndDate());
        m.setTeamID(Matchh.getTeamID());
        matchhrepository.save(m);
    }

    public void deleteMatchh(Integer Id ) {

        Matchh m = matchhrepository.findMatchhById(Id);

        if (m == null) {
            throw new ApiException("Invalid Id");
        }
        matchhrepository.delete(m);
    }

    public List<Matchh> matchesToday(){
        List<Matchh> m= matchhrepository.findMatchhByDate(LocalDate.now());
        if (m == null) {
            throw new ApiException("There are no matches today");
        }
        return m;
    }

    public List<Matchh> matchesInRange(LocalDate date1 , LocalDate date2){
        List<Matchh> m= matchhrepository.findMatchhByDateBetween(date1 , date2);
        if (m == null) {
            throw new ApiException("There are no matches between these dates");
        }
        return m;
    }

    public List<Matchh> matchesLocation(String location){
        List<Matchh> m= matchhrepository.findMatchhByLocation(location);
        if (m == null) {
            throw new ApiException("There are no matches in this location");
        }
        return m;
    }

    public List<Matchh> matchesDuration(Integer duration){
        List<Matchh> m= matchhrepository.findMatchhByDuration(duration);
        if (m == null) {
            throw new ApiException("There are no matches with this duration");
        }
        return m;
    }

    public List<Matchh> teamMatches(Integer teamId){
        List<Matchh> m= matchhrepository.findMatchhByTeamID(teamId);
        if (m == null) {
            throw new ApiException("There are no matches for this team");
        }
        return m;
    }
}
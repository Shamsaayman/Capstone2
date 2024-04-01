package org.example.capstone2.Repository;

import org.example.capstone2.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team findTeamByID (Integer Id);
    Team findTeamByName(String name);

    Team findTeamByIDAndName(Integer Id, String name);
}

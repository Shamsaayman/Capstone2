package org.example.capstone2.Repository;

import org.example.capstone2.Model.Matchh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MatchhRepository extends JpaRepository<Matchh, Integer> {
    Matchh findMatchhById (Integer Id);
    List<Matchh> findMatchhByDate(LocalDate date);

    List<Matchh> findMatchhByDateBetween(LocalDate date1 , LocalDate date2);

    List<Matchh> findMatchhByLocation(String location);

    List<Matchh> findMatchhByDuration(Integer duration);

    List<Matchh> findMatchhByTeamID(Integer Id);


}

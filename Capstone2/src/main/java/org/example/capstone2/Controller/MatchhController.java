package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.Matchh;
import org.example.capstone2.Service.MatchhService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/match")
@RequiredArgsConstructor
public class MatchhController {
    private final MatchhService MatchhService;
    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(MatchhService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity addMatchh(@RequestBody @Valid Matchh Matchh , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        MatchhService.addMatchh(Matchh);
        return ResponseEntity.status(200).body(new ApiResponse("Matchh added"));

    }
    @PutMapping("/update/{Id}")
    public ResponseEntity updateMatchh(@PathVariable Integer Id , @RequestBody @Valid Matchh Matchh, Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        MatchhService.updateMatchh(Id , Matchh);

        return ResponseEntity.status(200).body(new ApiResponse("Matchh updated"));
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteMatchh(@PathVariable Integer Id ){

        MatchhService.deleteMatchh(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Matchh deleted"));
    }

    @GetMapping("/gettoday")
    public ResponseEntity matchesToday(){

        return ResponseEntity.status(200).body(MatchhService.matchesToday());
    }

    @GetMapping("/matcherange/{date1}/{date2}")
    public ResponseEntity matchesInRange(@PathVariable LocalDate date1 , @PathVariable LocalDate date2){

        return ResponseEntity.status(200).body( MatchhService.matchesInRange(date1 , date2));
    }

    @GetMapping("/location/{location}")
    public ResponseEntity matchesLocation(@PathVariable String location){
        return ResponseEntity.status(200).body( MatchhService.matchesLocation(location));
    }

    @GetMapping("/duration/{duration}")
    public ResponseEntity matchesDuration(@PathVariable Integer duration){
        return ResponseEntity.status(200).body( MatchhService.matchesDuration(duration));
    }
    @GetMapping("/team/{teamid}")
    public ResponseEntity teamMatches(@PathVariable Integer teamid){
        return ResponseEntity.status(200).body( MatchhService.teamMatches(teamid));
    }
}

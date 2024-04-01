package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.Team;
import org.example.capstone2.Service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(teamService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity addTeam(@RequestBody @Valid Team team , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        teamService.addTeam(team);
        return ResponseEntity.status(200).body(new ApiResponse("Team added"));

    }

    @PutMapping("/update/{Id}")
    public ResponseEntity updateTeam(@PathVariable Integer Id , @RequestBody @Valid Team team , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        teamService.updateTeam(Id , team);

        return ResponseEntity.status(200).body(new ApiResponse("Team updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteTeam(@PathVariable Integer Id ){

        teamService.deleteTeam(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Team deleted"));
    }

    @GetMapping("/join/{userID}/{teamID}")
    public ResponseEntity joinTeam(@PathVariable Integer userID,@PathVariable Integer teamID ){
        return ResponseEntity.status(200).body( teamService.joinTeam(teamID,userID));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        return ResponseEntity.status(200).body(teamService.findByName(name));
    }


}

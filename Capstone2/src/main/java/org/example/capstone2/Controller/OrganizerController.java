package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.Organizer;
import org.example.capstone2.Service.OrganizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organizer")
@RequiredArgsConstructor
public class OrganizerController {
    private final OrganizerService organizerService;
    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(organizerService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity addOrganizer(@RequestBody @Valid Organizer organizer , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        organizerService.addOrganizer(organizer);
        return ResponseEntity.status(200).body(new ApiResponse("Organizer added"));

    }
    @PutMapping("/update/{Id}")
    public ResponseEntity updateOrganizer(@PathVariable Integer Id , @RequestBody @Valid Organizer organizer, Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        organizerService.updateOrganizer(Id , organizer);

        return ResponseEntity.status(200).body(new ApiResponse("Organizer updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteTeam(@PathVariable Integer Id ){

        organizerService.deleteOrganizer(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Organizer deleted"));
    }
}

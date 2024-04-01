package org.example.capstone2.Repository;

import org.example.capstone2.Model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    Organizer findOrganizerByID (Integer Id);
}

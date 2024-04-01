package org.example.capstone2.Service;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiException;
import org.example.capstone2.Model.Organizer;
import org.example.capstone2.Repository.OrganizerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerService {
    private final OrganizerRepository organizerRepository;

    public List<Organizer> getAll(){
        return organizerRepository.findAll();
    }

    public void addOrganizer(Organizer organizer){
        organizerRepository.save(organizer);
    }
    public void updateOrganizer(Integer Id , Organizer organizer) {

        Organizer o = organizerRepository.findOrganizerByID(Id);

        if (o == null) {
            throw new ApiException("Invalid Id");
        }

        o.setEmail(organizer.getEmail());
        o.setName(organizer.getName());
        organizerRepository.save(o);
    }
    public void deleteOrganizer(Integer Id ) {

        Organizer o = organizerRepository.findOrganizerByID(Id);

        if (o == null) {
            throw new ApiException("Invalid Id");
        }
        organizerRepository.delete(o);
    }
}

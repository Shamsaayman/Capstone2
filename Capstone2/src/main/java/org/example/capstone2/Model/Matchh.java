package org.example.capstone2.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Matchh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


//    @NotEmpty( message = "Date should be not empty")
//    @Column(columnDefinition ="date")
    private LocalDate date;


    @NotEmpty(message = "location should be not empty")
//@Column(columnDefinition = "varchar(10) not null")
    private String location ;


    @NotNull(message = "teamID should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer teamID ;

    @NotNull(message = "organizerID should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer organizerID ;

     @NotNull(message = "duration should be not empty")
   @Column(columnDefinition = "int not null")
     private Integer duration;
}

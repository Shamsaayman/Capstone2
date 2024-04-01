package org.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;
//    @NotEmpty(message = "username should be not empty")
//    @Size(min = 4 , message = "username should be more than 4 char")
//    @Column(columnDefinition = "varchar(5) not null")
    private String username ;
//    @NotEmpty(message = "password should be not empty")
//    @Size(min = 5 , message = "password should be more than 4 char")
//    @Column(columnDefinition = "varchar(15) not null unique")
    private String password ;
//    @Email
//    @NotEmpty(message = "email should be not empty")
//    @Column(columnDefinition = "varchar(30) not null unique")
    private String email ;
    @NotNull(message = "age should be not empty")
    @Column(columnDefinition = "int not null ")
    private Integer age;
    @NotNull(message = "weight should be not empty")
    @Column(columnDefinition = "int not null ")
    private Integer weight;
//    @NotEmpty(message = "gender should be not empty")
//    @Column(columnDefinition = "varchar(5) check(gender='male' or gender='female')")
    private String gender ;
    @NotEmpty(message = "sport should be not empty")
//    @Column(columnDefinition = "varchar(5) not null ")
    private String sport ;
    @NotNull(message = "teamID should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer teamID ;


}

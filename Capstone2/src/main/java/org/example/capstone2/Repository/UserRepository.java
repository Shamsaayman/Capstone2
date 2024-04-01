package org.example.capstone2.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.capstone2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByID(Integer Id);
    User findUserByUsernameAndPassword(String username , String password);

    List<User> findUserByAgeBetween(Integer age1 , Integer age2);

    List<User> findUserByWeightAfter(Integer weight);

    List<User> findUserByGender(String gender);

    List<User> findUserBySport(String sport);



}

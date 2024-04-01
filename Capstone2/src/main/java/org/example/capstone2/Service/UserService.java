package org.example.capstone2.Service;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiException;
import org.example.capstone2.Model.Team;
import org.example.capstone2.Model.User;
import org.example.capstone2.Repository.TeamRepository;
import org.example.capstone2.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public List<User> getAll(){

        return userRepository.findAll();
    }


    public void addUser(User user){
        Team t = teamRepository.findTeamByID(user.getTeamID());
        if (t == null){
            throw new ApiException("Invalid Id");
        }
        userRepository.save(user);
    }

    public void updateUser(Integer Id , User user){
        User u = userRepository.findUserByID(Id);
        if (u == null){
            throw new ApiException("Invalid Id");
        }

        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setGender(user.getGender());
        u.setSport(user.getSport());
        u.setWeight(user.getWeight());
        userRepository.save(u);

    }


    public void deleteUser(Integer Id){
        User u = userRepository.findUserByID(Id);
        if (u == null){
            throw new ApiException("Invalid Id");
        }

        userRepository.delete(u);

    }

    public User findByUsernameAndPassword(String username , String password){
        User u = userRepository.findUserByUsernameAndPassword(username, password);
        if(u==null){
            throw new ApiException("Invalid username and password");
        }
        return u;
    }

    public List<User>getAgeRange(Integer age1 , Integer age2){
        List<User>u = userRepository.findUserByAgeBetween(age1 , age2);
        if(u==null){
            throw new ApiException("Invalid ids");
        }
        return u;
    }

    public List<User>getWeightAbove(Integer weight){
        List<User>u = userRepository.findUserByWeightAfter(weight);
        if(u==null){
            throw new ApiException("Invalid weight");
        }
        return u;
    }


    public List<User>getByGender(String gender){
        List<User>u = userRepository.findUserByGender(gender);
        if(u==null){
            throw new ApiException("Invalid gender");
        }
        return u;
    }


    public List<User>getBySport(String sport){
        List<User>u = userRepository.findUserBySport(sport);
        if(u==null){
            throw new ApiException("Invalid sport");
        }
        return u;
    }


    public String findCategory(Integer id){
        User u = userRepository.findUserByID(id);
        if (u == null){
            throw new ApiException("Invalid Id");
        }
      if(u.getAge()<12){
          return "Your Category is: Cadet";
      } else if ((u.getAge() < 18)) {
          return "Your Category is: Junior";
      } else {
          return "Your Category is: Senior";
      }

    }


}

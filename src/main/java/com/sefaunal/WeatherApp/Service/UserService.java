package com.sefaunal.WeatherApp.Service;

import com.sefaunal.WeatherApp.Model.User;
import com.sefaunal.WeatherApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean createUser(User user){
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public User findByUserMail(String mail){
        return userRepository.findByUserMail(mail);
    }
}

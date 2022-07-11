package com.sefaunal.WeatherApp.Controller;

import com.sefaunal.WeatherApp.Model.User;
import com.sefaunal.WeatherApp.Model.Weather;
import com.sefaunal.WeatherApp.Repository.UserRepository;
import com.sefaunal.WeatherApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class WeatherController {
    @Autowired
    UserService userService;

    @PostMapping("/home/weather/save")
    public @ResponseBody Boolean createWeather(@RequestBody Weather weather, Principal principal){
        User user = userService.findByUserMail(principal.getName());
        try {
            weather.setUser(user);
            user.getWeatherList().add(weather);
            userService.createUser(user);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

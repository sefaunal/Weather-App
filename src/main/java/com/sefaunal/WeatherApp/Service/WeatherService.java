package com.sefaunal.WeatherApp.Service;

import com.sefaunal.WeatherApp.Model.User;
import com.sefaunal.WeatherApp.Model.Weather;
import com.sefaunal.WeatherApp.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    public void saveWeather(Weather weather) {
        weatherRepository.save(weather);
    }

    public List<Weather> findWeatherByUser(User user){
        return weatherRepository.findByUser(user);
    }

    public void deleteByWeatherID(Long weatherID){
        weatherRepository.deleteById(weatherID);
    }

    public Weather findByWeatherID(Long weatherID){
        return weatherRepository.findById(weatherID).get();
    }
}

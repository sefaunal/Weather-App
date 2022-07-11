package com.sefaunal.WeatherApp.Repository;

import com.sefaunal.WeatherApp.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}

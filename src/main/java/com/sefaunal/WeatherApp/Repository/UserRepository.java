package com.sefaunal.WeatherApp.Repository;

import com.sefaunal.WeatherApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserMail(String mail);

    List<User> findByUserRole(String role);
}

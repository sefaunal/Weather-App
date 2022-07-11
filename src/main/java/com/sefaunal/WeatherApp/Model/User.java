package com.sefaunal.WeatherApp.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;

    private String userName;

    private String userPassword;

    @Column(columnDefinition = "VARCHAR(150) NOT NULL", unique = true)
    private String userMail;

    private String userRole;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime userCreationDate;

    private String userImageURL;

}

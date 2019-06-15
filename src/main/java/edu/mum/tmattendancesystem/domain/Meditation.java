package edu.mum.tmattendancesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Meditation {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String location;

    private Date date;

    private MeditationType type;

    private MeditationTime medTime;
}

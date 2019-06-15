package edu.mum.tmattendancesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
public class MeditationTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalTime startTime;

    private LocalTime endTime;
}

package edu.mum.tmattendancesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Meditation {

    public enum MeditationType {

        REGULAR, DC;
    }

    @Id
    private LocalDate date;

    private String location;

    @Enumerated(EnumType.STRING)
    private MeditationTimeType timeType;

    @Enumerated(EnumType.STRING)
    private MeditationType type;

    @ManyToOne
    private Block block;
}

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

    private String location;

    @Id
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private MeditationTimeType timeType;

    @Enumerated(EnumType.STRING)
    private MeditationType type;

    @ManyToOne
    private Block block;
}

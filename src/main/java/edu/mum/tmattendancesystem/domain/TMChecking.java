package edu.mum.tmattendancesystem.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TMChecking {

    public enum CheckingType {
        INDIVIDUAL, GROUP;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private CheckingType checkingType;
}

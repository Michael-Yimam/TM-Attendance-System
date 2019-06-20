package edu.mum.tmattendancesystem.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

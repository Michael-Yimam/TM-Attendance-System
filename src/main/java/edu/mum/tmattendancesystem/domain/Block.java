package edu.mum.tmattendancesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Block {

    @Id
    private String name;

    private Integer numberOfWeeks;

    private LocalDate startDate;

    private LocalDate endDate;

    private int numberOfMeditation;

}

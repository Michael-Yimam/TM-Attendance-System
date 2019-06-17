package edu.mum.tmattendancesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Block {

    @Id
    @Column(name = "Block_Id")
    private String name;

    private Integer numberOfWeeks;

    private LocalDate startDate;

    private LocalDate endDate;

    private int numberOfMeditation;

}

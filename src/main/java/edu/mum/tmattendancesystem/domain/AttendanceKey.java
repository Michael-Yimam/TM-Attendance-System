package edu.mum.tmattendancesystem.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AttendanceKey implements Serializable {


    private String studentId;

    private LocalDate date;

}

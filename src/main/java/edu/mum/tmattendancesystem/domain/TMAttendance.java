package edu.mum.tmattendancesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TMAttendance {

    @EmbeddedId
    private AttendanceKey attendanceKey;

    private String barcode;

    private String location;

    @Enumerated(EnumType.STRING)
    private MeditationTimeType meditationTimeType;
}

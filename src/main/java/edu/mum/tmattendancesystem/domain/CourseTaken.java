package edu.mum.tmattendancesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseTaken {
    @Id
    private int id;

    @OneToOne
    @JoinColumn
    private Student studentId;

    @OneToOne
    @JoinColumn
    private Course courseId;
}

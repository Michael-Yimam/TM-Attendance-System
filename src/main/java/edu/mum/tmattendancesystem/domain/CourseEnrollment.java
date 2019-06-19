package edu.mum.tmattendancesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseEnrollment {

    @Id
    @Column(name = "Enrollment_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ManyToMany
    //private List<Student> students;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Student student;

    @OneToOne
    @JoinColumn(name = "Course_Id")
    private CourseOffer course;
}

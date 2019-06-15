package edu.mum.tmattendancesystem.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student{

    @Id
    @Column(name = "student_id")
    private String id;

    private String barcode;

    private String entry;

//    @Ignore
//    private List<TMAttendance> meditations;

    @OneToMany
    List<Retreat> retreats;

    @OneToMany
    List<TMChecking> tmCheckings;


}

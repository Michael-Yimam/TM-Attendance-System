package edu.mum.tmattendancesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Student{

    @Id
    @Column(name = "student_id")
    private String id;

    private String name;

    private String barcode;

    private String entry;

//    @OneToOne
//    @JoinTable(name = "credential")
//    private UserCredentials credentials;

//    @Ignore
//    private List<TMAttendance> meditations;

    @OneToMany
    private List<Retreat> retreats;

    @OneToMany
    private List<TMChecking> tmCheckings;


}

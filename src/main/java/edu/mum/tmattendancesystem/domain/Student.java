package edu.mum.tmattendancesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Student extends User{

//    @Id
//    @Column(name = "student_id")
//    private String id;

    private String barcode;

    private String entry;

//    @Ignore
//    private List<TMAttendance> meditations;

    @OneToMany
    List<Retreat> retreats;

    @OneToMany
    List<TMChecking> tmCheckings;


}

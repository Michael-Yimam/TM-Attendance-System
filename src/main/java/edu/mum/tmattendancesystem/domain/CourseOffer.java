package edu.mum.tmattendancesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="CourseOffer")
@NoArgsConstructor
@AllArgsConstructor
public class CourseOffer {

    @Id
    @Column(name="COURSE_ID")
    private String id;

    @Column(name="COURSE_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Block_Id")
    private Block block;

    @ManyToOne
    @JoinColumn(name = "Faculty_Id")
    private Faculty faculty;
}

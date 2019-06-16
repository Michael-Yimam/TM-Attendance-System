package edu.mum.tmattendancesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    private String id;

    private String name;

    @OneToOne
    @JoinColumn
    private Block blockId;

    @OneToOne
    @JoinColumn
    private Faculty facultyId;
}

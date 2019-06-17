package edu.mum.tmattendancesystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Faculty {

    @Id
    @Column(name = "Faculty_Id")
    private String id;

    private String name;

    private String email;

    private String password;


}

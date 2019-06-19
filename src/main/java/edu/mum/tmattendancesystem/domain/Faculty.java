package edu.mum.tmattendancesystem.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Faculty {

    @Id
    @Column(name = "Faculty_Id")
    private String id;

    private String name;

    private String email;

}

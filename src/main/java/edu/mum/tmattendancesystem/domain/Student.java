package edu.mum.tmattendancesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Student {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    /*More properties to be added */
}

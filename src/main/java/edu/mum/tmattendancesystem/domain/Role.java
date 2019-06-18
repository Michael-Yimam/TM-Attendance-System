package edu.mum.tmattendancesystem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id")
    private Long id;
    @Column(name = "role")
    private String name;
}

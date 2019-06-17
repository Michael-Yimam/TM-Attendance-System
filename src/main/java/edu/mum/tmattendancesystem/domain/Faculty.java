package edu.mum.tmattendancesystem.domain;

import lombok.*;

import javax.persistence.*;

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

//    @OneToOne
//    @JoinColumn(name = "userCredential")
//    private UserCredentials credentials;
}

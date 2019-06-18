package edu.mum.tmattendancesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserCredentials {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;*/

    @Size(min = 4, max = 25, message = "User must be between 4 and 25 characters")
    @NotEmpty(message = "*Please provide a admin name")
    @Id
    @Column(name="user_id")
    private String userName;

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    private String role;

    private int active;

}

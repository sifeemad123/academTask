package com.example.TODO.Entity;

import com.example.TODO.Entity.Enum.GradeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private GradeEnum grade;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private TeamEntity team;

}

package com.example.TODO.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @OneToMany()
    @JoinColumn(name = "team_id")
    private List<TeamEntity> teams;

    @OneToMany
    @JoinColumn(name = "teacher_id")
    private List<TeacherEntity> teacher;

}

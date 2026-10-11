package com.example.TODO.Entity;

import com.example.TODO.Entity.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Sessions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id")
    private List<TeamEntity> teams;

    private Date startDate;

    private Date endDate;

    @Enumerated(EnumType.STRING)
    private Status status;
}

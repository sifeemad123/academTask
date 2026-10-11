package com.example.TODO.DTO;

import com.example.TODO.Entity.Enum.Status;
import com.example.TODO.Entity.TeamEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionsDTO {
    @NotBlank
    private Date startDate;
    @NotBlank
    private Date endDate;
    @NotBlank
    private Status status;
    @NotBlank
    private List<TeamEntity> teams;
}

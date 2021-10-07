package com.example.facultyService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "faculty")
public class Faculty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "faculty_name", columnDefinition = "NVARCHAR(255)")
    @NotBlank(message = "faculty name can't blank")
    private String facultyName;
}

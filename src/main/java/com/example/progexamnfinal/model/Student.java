package com.example.progexamnfinal.model;

import lombok.*;
import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    private int   studentId  ;
    private String  firstName;
    private String  lastName  ;
    private LocalDate dateOfBirth ;
    private String email;
}

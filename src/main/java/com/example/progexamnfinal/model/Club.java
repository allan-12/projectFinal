package com.example.progexamnfinal.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Club {
    private int  clubId;
    private String clubName;
    private String clubDescription;
    private LocalDate creationDate;

}

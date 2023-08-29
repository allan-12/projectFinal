package com.example.progexamnfinal.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Membre {
    private int membreId;
    private LocalDate membershipDate;
    private String role;
    private Club club;
}
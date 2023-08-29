package com.example.progexamnfinal.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Event_Participation {
    private int  participationId;
    private LocalDate participationDate;
    private int eventId;
    private int studentId;
}

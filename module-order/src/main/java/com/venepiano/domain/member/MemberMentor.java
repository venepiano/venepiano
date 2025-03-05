package com.venepiano.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberMentor { // 멘토 - 멘티
    
    private String menteeId;
    private String mentorId;
    private LocalDate startDate;
    private LocalDate endDate;
    private MemberMentorStatus status;
    
}

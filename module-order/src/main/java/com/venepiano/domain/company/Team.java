package com.venepiano.domain.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Team { // 팀

    private String teamId;
    private String teamName;
    private String deptId;
    private String managerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

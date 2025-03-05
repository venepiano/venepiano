package com.venepiano.domain.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department { // 부서

    private String deptId;
    private String deptName;
    private String divId;
    private String managerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

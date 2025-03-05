package com.venepiano.domain.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Division { // 본부

    private String divId;
    private String divName;
    private String managerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

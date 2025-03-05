package com.venepiano.domain.point;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PointMaster { // 포인트
    
    private String pointId;
    private String mbrId;
    private PointType pointType;
    private Long pointAmount;
    private String paymentId;
    private LocalDate expireDate;
    private PointStatus status;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
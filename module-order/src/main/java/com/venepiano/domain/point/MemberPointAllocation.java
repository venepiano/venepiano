package com.venepiano.domain.point;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberPointAllocation { // 회원별 포인트 배정
    
    private String mbrPointId;
    private String allocationId;
    private String mbrId;
    private Long allocatedPoint;
    private Long usedPoint;
    private Long remainingPoint;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

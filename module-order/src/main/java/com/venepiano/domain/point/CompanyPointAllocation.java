package com.venepiano.domain.point;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPointAllocation { // 회사별 포인트 배정년도

    private String allocationId;
    private String custCoCd;
    private Integer assnYr;
    private Long totalPoint;
    private Long remainingPoint;
    private LocalDate startDate;
    private LocalDate endDate;
    private PointStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

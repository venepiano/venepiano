package com.venepiano.domain.point;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PointUsageHistory { // 포인트 사용 이력

    private String usageId;
    private String mbrPointId;
    private String paymentId;
    private Long usageAmount;
    private LocalDateTime usageDate;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

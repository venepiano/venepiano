package com.venepiano.domain.vendor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vendor { // 상품 판매 업체
        
    private String vendorId;
    private String vendorName;
    private String businessNo;
    private String contactPerson;
    private String contactEmail;
    private String contactPhone;
    private String address;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private VendorStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}

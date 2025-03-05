package com.venepiano.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum BankCode {

    BC001("001", "신한은행"),
    BC002("002", "국민은행"),
    BC003("003", "기업은행"),
    BC004("004", "농협은행"),
    BC005("005", "하나은행");

    private final String code;
    private final String description;

    public static BankCode fromCode(String code) {
        for (BankCode bankCode : BankCode.values()) {
            if (Objects.equals(bankCode.code, code)) {
                return bankCode;
            }
        }

        throw new IllegalArgumentException("No BankCode found for code: " + code);
    }

}

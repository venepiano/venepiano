package com.venepiano.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum CardCode {

    CC001("신용카드"),
    CC002("체크카드");

    private final String description;

}

package com.venepiano.controller.responsebody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponseBody<T> {
    private T body;
    private LocalDateTime timeStamp;

    public static <T> GeneralResponseBody<T> from(T body) {
        return new GeneralResponseBody<>(body, LocalDateTime.now());
    }
}

package com.sparta.springtodo.dto.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
public class ErrorResponseDto {

    private final Error error;

    public ErrorResponseDto(int status, String message) {
        this.error = new Error(status, message);
    }

    @JsonPropertyOrder({"status", "message"})
    record Error(
            int status,
            @JsonProperty("message")
            String message
    ) {}
}

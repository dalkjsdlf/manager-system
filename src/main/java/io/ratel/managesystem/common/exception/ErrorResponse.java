package io.ratel.managesystem.common.exception;

public record ErrorResponse(
        String code,
        String message
) {
}

package io.fds.managesystem.common.exception;

public record ErrorResponse(
        String code,
        String message
) {
}

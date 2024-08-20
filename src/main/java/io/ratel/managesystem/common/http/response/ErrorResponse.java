package io.ratel.managesystem.common.http.response;

public record ErrorResponse(
        String code,
        String message
) {
}

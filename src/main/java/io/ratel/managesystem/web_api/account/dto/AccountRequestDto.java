package io.ratel.managesystem.web_api.account.dto;

import lombok.Builder;

@Builder
public record AccountRequestDto(String userId, String appUserId, String appName, String password) {
}

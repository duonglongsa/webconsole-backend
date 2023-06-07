package com.webconsole.miniappmanager.exception;

import lombok.Value;

@Value
public record BusinessErrorCode(int code, String message, int httpStatus) {
}

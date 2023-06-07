package com.webconsole.miniappmanager.exception;

import lombok.Value;

public record BusinessErrorCode(int code, String message, int httpStatus) {
}

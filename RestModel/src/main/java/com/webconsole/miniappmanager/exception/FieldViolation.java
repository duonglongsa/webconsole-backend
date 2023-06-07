package com.webconsole.miniappmanager.exception;

import lombok.Value;

public record FieldViolation(String field, String description) {
}

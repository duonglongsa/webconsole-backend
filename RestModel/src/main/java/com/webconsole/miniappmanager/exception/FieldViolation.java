package com.webconsole.miniappmanager.exception;

import lombok.Value;

@Value
public record FieldViolation(String field, String description) {
}

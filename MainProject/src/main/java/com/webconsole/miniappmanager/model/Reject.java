package com.webconsole.miniappmanager.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Reject {
    private String version;

    @NotNull(message = "Reason is not null")
    @NotBlank(message = "Reason is not blank")
    private String reason;
}

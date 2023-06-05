package com.webconsole.miniappmanager.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class RollBack {
    @NotNull(message = "App Id is not null")
    private String appId;
    @Pattern(regexp = "^(\\d+\\.)?(\\d+\\.)?(\\*|\\d+)$", message = "Version format invalid")
    private String version;
    @NotNull(message = "Update Time is not null")
    private String updateTime;
}

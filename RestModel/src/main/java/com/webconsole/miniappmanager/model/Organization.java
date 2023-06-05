package com.webconsole.miniappmanager.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Organization {
    @NotBlank(message = "Organization Type can not blank")
    @NotNull(message = "Organization Type can not null")
    @Pattern(message = "Organization Type is personal or enterprise", regexp = "^personal|enterprise")
    private String orgType;
    private String orgName;
}

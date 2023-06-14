package com.webconsole.miniappmanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfoDTO {
    @JsonProperty("id")
    private String userId;
    private String firstName;
    private String lastName;
    private String organization;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}

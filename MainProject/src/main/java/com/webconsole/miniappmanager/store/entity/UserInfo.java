package com.webconsole.miniappmanager.store.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webconsole.miniappmanager.model.Organization;
import lombok.Data;

@Data
public class UserInfo {
    @JsonProperty("id")
    private String userId;
    private String firstName;
    private String lastName;
    private Organization organization;
    private boolean root;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}

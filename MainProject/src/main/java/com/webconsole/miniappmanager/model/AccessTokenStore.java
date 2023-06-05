package com.webconsole.miniappmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccessTokenStore {
    @JsonProperty("access_token")
    private String accessToken;
}

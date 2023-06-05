package com.webconsole.miniappmanager.store.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MiniAppType {
    @JsonProperty("id")
    private String appTypeId;
    private String name;
}

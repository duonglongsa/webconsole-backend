package com.webconsole.miniappmanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MiniAppTypeDTO {
    @JsonProperty("id")
    private String appTypeId;
    private String name;
}

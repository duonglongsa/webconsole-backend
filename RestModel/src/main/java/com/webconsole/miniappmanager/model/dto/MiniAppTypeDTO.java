package com.webconsole.miniappmanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * @author tientv2.os
 * @desciption Mini app type DTO model
 * @date 30/3/2022
 */
@Data
public class MiniAppTypeDTO {
    @JsonProperty("id")
    private String appTypeId;
    private String name;
}

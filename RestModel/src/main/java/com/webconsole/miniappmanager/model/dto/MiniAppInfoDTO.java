package com.webconsole.miniappmanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author tientv2.os
 * @desciption Mini app info model dto
 * @date 30/3/2022
 */
@Data
public class MiniAppInfoDTO {
    @JsonProperty("id")
    private String appId;
    private String storeId;
    private UserInfoDTO userInfo;
    private String description;
    private MiniAppTypeDTO appType;
    private String displayName;
    private String icon;
    private VersionDTO version;
    private List<String> promotionalImageUrl;
    private String promotionalText;
    private List<FieldDTO> fields;
    private String banner;
    private List<String> hashtags;
    private String packageId;
    private String status;
    private String updateTime;
    private String reasonReject;
    private int numberOfDownloads;

    public String getVersion() {
        return this.version != null ? this.version.getX() + "." + this.version.getY() + "." + this.version.getZ(): "";
    }
}

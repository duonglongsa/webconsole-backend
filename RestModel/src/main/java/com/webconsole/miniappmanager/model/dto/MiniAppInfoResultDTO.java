package com.webconsole.miniappmanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.json.JSONObject;

import java.util.List;

@Data
public class MiniAppInfoResultDTO {
    @JsonProperty("id")
    private String appId;
    private String storeId;
    private String description;
    private MiniAppTypeDTO appType;
    private String displayName;
    private String icon;
    private String version;
    private List<String> promotionalImageUrl;
    private String promotionalText;
    private List<FieldDTO> fields;
    private String banner;
    private List<String> hashtags;
    private String packageId;
    private String status;
    private String updateTime;
    private String versionLive;
    private int numberOfDownloads;

    public String getVersion() {
        try {
            JSONObject jsonObject = new JSONObject(this.version);
            return jsonObject.get("x") + "." + jsonObject.get("y") + "." + jsonObject.get("z");
        } catch (Exception e) {
            return this.version;
        }
    }

    public String getVersionLive() {
        try {
            JSONObject jsonObject = new JSONObject(this.versionLive);
            return jsonObject.get("x") + "." + jsonObject.get("y") + "." + jsonObject.get("z");
        } catch (Exception e) {
            return this.versionLive;
        }
    }
}

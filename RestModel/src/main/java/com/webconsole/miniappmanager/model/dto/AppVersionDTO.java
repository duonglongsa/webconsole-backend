package com.webconsole.miniappmanager.model.dto;

import lombok.Data;
import org.json.JSONObject;

import java.util.List;

@Data
public class AppVersionDTO {
    private String appId;
    private String storeId;
    private UserInfoDTO userInfo;
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
    private String reasonReject;

    public String getVersion() {
        try {
            JSONObject jsonObject = new JSONObject(this.version);
            return jsonObject.get("x") + "." + jsonObject.get("y") + "." + jsonObject.get("z");
        } catch (Exception e) {
            return this.version;
        }
    }
}

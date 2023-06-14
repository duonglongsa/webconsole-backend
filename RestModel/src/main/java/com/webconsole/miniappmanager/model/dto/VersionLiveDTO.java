package com.webconsole.miniappmanager.model.dto;

import lombok.Data;
import org.json.JSONObject;

@Data
public class VersionLiveDTO {
    private String appId;
    private String version;
    private String updateTime;

    public String getVersion() {
        try {
            JSONObject jsonObject = new JSONObject(this.version);
            return jsonObject.get("x") + "." + jsonObject.get("y") + "." + jsonObject.get("z");
        } catch (Exception e) {
            return this.version;
        }
    }

}

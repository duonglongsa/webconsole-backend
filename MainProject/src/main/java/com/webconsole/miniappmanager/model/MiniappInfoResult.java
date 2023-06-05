package com.webconsole.miniappmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webconsole.miniappmanager.store.entity.AppVersion;
import lombok.Data;

@Data
public class MiniappInfoResult {
    @JsonProperty("id")
    private String appId;
    private String packageId;
    private int numberOfDownloads;
    private AppVersion appVersions;
}

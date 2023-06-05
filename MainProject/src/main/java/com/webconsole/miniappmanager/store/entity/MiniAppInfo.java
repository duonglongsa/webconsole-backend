package com.webconsole.miniappmanager.store.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class MiniAppInfo {
    @JsonProperty("id")
    private String appId;
    private String packageId;
    private int numberOfDownloads;
    private Version versionLive;
    private List<AppVersion> appVersions;
}

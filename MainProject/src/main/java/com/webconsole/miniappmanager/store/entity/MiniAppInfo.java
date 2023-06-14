package com.webconsole.miniappmanager.store.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Accessors(chain = true)
@Document("mini-app-info")
public class MiniAppInfo {
    @Id
    private String appId;
    private String packageId;
    private int numberOfDownloads;
    private Version versionLive;
    private List<AppVersion> appVersions;
}

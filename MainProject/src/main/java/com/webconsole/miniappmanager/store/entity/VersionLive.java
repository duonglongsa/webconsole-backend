package com.webconsole.miniappmanager.store.entity;

import lombok.Data;

@Data
public class VersionLive {
    private String appId;
    private Version version;
    private String updateTime;
}

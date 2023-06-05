package com.webconsole.miniappmanager.store.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class AppVersion {
    private String fullName;
    private String description;
    private String fileId;
    private String metadata;
    private String signature;
    private MiniAppType appType;
    private String displayName;
    private String icon;
    private Version version;
    private String banner;
    private List<String> promotionalImageUrl;
    private String promotionalText;
    private List<Field> fields;
    private String programVersion;
    private List<String> hashtags;
    private String status;
    private String updateTime;
    private String createTime;
    private String reasonReject;

}

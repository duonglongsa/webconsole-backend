package com.webconsole.miniappmanager.store.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Accessors(chain = true)
@Document("app-version")
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

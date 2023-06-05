package com.webconsole.miniappmanager.model;

import com.webconsole.miniappmanager.store.entity.Field;
import com.webconsole.miniappmanager.store.entity.MiniAppType;
import lombok.Data;

import java.util.List;

@Data
public abstract class AbsAttachmentFile {
    private String appId;
    private String description;
    private MiniAppType appType;
    private String displayName;
    private String promotionalText;
    private List<Field> fields;
    private List<String> hashtags;
    private String createTime;
}

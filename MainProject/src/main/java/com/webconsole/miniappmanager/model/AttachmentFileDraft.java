package com.webconsole.miniappmanager.model;

import com.webconsole.miniappmanager.store.entity.Field;
import com.webconsole.miniappmanager.store.entity.MiniAppType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AttachmentFileDraft extends AbsAttachmentFile {
    @NotNull(message = "appId can not null")
    @NotBlank(message = "appId can not blank")
    private String appId;
    private String description;
    private MiniAppType appType;
    @NotNull(message = "display name can not null")
    @NotBlank(message = "display name can not blank")
    private String displayName;
    private String promotionalText;
    private List<Field> fields;
    private List<String> hashtags;
    private String createTime;
}

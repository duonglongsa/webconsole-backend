package com.webconsole.miniappmanager.model;

import com.webconsole.miniappmanager.store.entity.Field;
import com.webconsole.miniappmanager.store.entity.MiniAppType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class MiniAppInfoUpdate extends AbsAttachmentFile{
    private String description;
    @NotNull(message = "app type is not null")
    private MiniAppType appType;
    @NotNull(message = "display name can not null")
    @NotBlank(message = "display name can not blank")
    private String displayName;
    private String promotionalText;
    @NotNull(message = "fields is not null")
    private List<Field> fields;
    private List<String> hashtags;
    @NotNull(message = "version is not null")
    @Pattern(regexp = "^(\\d+\\.)?(\\d+\\.)?(\\*|\\d+)$", message = "Version format invalid")
    private String version;
    private String icon;
    private List<String> promotionalImageUrl;
    private String banner;
    private String updateTime;
}

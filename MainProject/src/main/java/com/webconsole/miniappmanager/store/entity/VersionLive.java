package com.webconsole.miniappmanager.store.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document("version-live")
public class VersionLive {
    @Id
    private String appId;
    private Version version;
    private String updateTime;
}

package com.webconsole.miniappmanager.store.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document("mini-app-type")
public class MiniAppType {
    @Id
    private String appTypeId;
    private String name;
}

package com.webconsole.miniappmanager.store.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Accessors(chain = true)
@Document("store")
public class Store {
    @Id
    private String id;
    private UserInfo userInfo;
    private List<MiniAppInfo> miniapps;
}

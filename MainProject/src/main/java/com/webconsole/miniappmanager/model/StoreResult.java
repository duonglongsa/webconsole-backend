package com.webconsole.miniappmanager.model;

import com.webconsole.miniappmanager.store.entity.UserInfo;
import lombok.Data;

@Data
public class StoreResult {
    private String id;
    private UserInfo userInfo;
    private MiniappInfoResult miniapp;
}

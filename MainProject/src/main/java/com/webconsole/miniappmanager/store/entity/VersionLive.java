package com.webconsole.miniappmanager.store.entity;

import lombok.Data;

/**
 * @author tientv2.os
 * @desciption Version live model
 * @date 5/5/2022
 */
@Data
public class VersionLive {
    private String appId;
    private Version version;
    private String updateTime;
}

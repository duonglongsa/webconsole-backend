package com.webconsole.miniappmanager.model;

import lombok.Data;

@Data
public class PublicKey {
    private String id;
    private String ecKey;
    private String pemKey;
}

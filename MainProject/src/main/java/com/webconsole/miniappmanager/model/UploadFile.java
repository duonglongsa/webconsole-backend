package com.webconsole.miniappmanager.model;

import lombok.Data;

import java.util.Map;

@Data
public class UploadFile {
    private String createdBy;
    private String description;
    private String docCode;
    private String docType;
    private String expiredDate;
    private String serviceName;
    private String state;
    Map<String, String> params;
}

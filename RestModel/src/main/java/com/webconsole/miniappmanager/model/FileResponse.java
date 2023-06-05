package com.webconsole.miniappmanager.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FileResponse {
    private String id;
    private String fileName;
    private String serviceName;
    private String localLocation;
    private String onlinePath;
    private Long fileSizeInBytes;
    private String description;
    private String fileType;
    private String docCode;
    private String docType;
    private String ecmFileId;
    private String ecmFolderId;
    private String ecmDownloadUrl;
    private LocalDateTime retryTime;
    private int retry;
    private FileStatus status;
    private FileState state;
    private String bizRefId;
    private String customerId;
    private String bpmLoanId;
}

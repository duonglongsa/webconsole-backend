package com.webconsole.miniappmanager.store.service;

import com.webconsole.miniappmanager.model.FileResponse;
import com.webconsole.miniappmanager.model.MultiPartFiles;
import org.springframework.util.MultiValueMap;

public interface FileService {
    FileResponse uploadFile(String refNo, MultiValueMap<String, String> params, MultiPartFiles file);

    FileResponse getById(String refNo, String id);

    void update(String id);

    byte[] download(String serviceName, String id);
}

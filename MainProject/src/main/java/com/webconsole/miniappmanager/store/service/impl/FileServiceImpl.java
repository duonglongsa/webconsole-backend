package com.webconsole.miniappmanager.store.service.impl;

import com.webconsole.miniappmanager.model.FileResponse;
import com.webconsole.miniappmanager.model.MultiPartFiles;
import com.webconsole.miniappmanager.store.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public FileResponse uploadFile(String refNo, MultiValueMap<String, String> params, MultiPartFiles file) {
        return null;
    }

    @Override
    public FileResponse getById(String refNo, String id) {
        return null;
    }

    @Override
    public void update(String id) {

    }

    @Override
    public byte[] download(String serviceName, String id) {
        return new byte[0];
    }
}

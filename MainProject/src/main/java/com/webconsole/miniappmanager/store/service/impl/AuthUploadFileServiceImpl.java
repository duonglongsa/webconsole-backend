package com.webconsole.miniappmanager.store.service.impl;

import com.webconsole.miniappmanager.model.AccessTokenStore;
import com.webconsole.miniappmanager.store.service.IAuthUploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUploadFileServiceImpl implements IAuthUploadFileService {

    private final AuthUploadFileRequest authUploadFileRequest;

    public String getToken() {
        AccessTokenStore accessTokenStore = authUploadFileRequest.getToken();
        return accessTokenStore.getAccessToken();
    }
}

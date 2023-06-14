package com.webconsole.miniappmanager.store.service.impl;

import com.webconsole.miniappmanager.model.*;
import com.webconsole.miniappmanager.model.dto.MiniAppInfoDTO;
import com.webconsole.miniappmanager.model.dto.MiniAppInfoResultDTO;
import com.webconsole.miniappmanager.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    @Override
    public List<MiniAppInfoResultDTO> getStore() {
        return null;
    }

    @Override
    public List<MiniAppInfoResultDTO> findByUserId(String userId) {
        return null;
    }

    @Override
    public MiniAppInfoDTO getMiniAppInfo(String storeId, String id) {
        return null;
    }

    @Override
    public List<String> getAppVersions(String storeId, String id) {
        return null;
    }

    @Override
    public List<MiniAppInfoDTO> getMiniAppByName(String name) {
        return null;
    }

    @Override
    public Manifest getManifest(String miniappId, String versionId) {
        return null;
    }

    @Override
    public Map<String, Object> getMetadataByVersion(String miniappId, Object versionId) {
        return null;
    }

    @Override
    public Map<String, Object> getMetadata(String miniappId) {
        return null;
    }

    @Override
    public PublicKey getPublicKey() {
        return null;
    }

    @Override
    public MiniAppInfoResultDTO updateDraft(String storeId, String id, MiniAppInfoUpdateDraft miniAppInfo, MultiPartFiles files) {
        return null;
    }

    @Override
    public MiniAppInfoResultDTO publicMiniapp(String storeId, String id, MiniAppInfoUpdate miniAppInfo, MultiPartFiles files) {
        return null;
    }

    @Override
    public MiniAppInfoResultDTO approve(String storeId, String id) {
        return null;
    }

    @Override
    public MiniAppInfoResultDTO reject(String storeId, String id, Reject reject) {
        return null;
    }

    @Override
    public MiniAppInfoResultDTO update(String storeId, String id, MiniAppInfoUpdate miniAppInfo, MultiPartFiles files) {
        return null;
    }

    @Override
    public Void rollBack(String storeId, RollBack rollBack) {
        return null;
    }

    @Override
    public Void delete(String storeId, String id) {
        return null;
    }
}

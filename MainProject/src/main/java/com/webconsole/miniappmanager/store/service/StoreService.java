package com.webconsole.miniappmanager.store.service;

import com.webconsole.miniappmanager.model.*;
import com.webconsole.miniappmanager.model.dto.MiniAppInfoDTO;
import com.webconsole.miniappmanager.model.dto.MiniAppInfoResultDTO;

import java.util.List;
import java.util.Map;

public interface StoreService {
    List<MiniAppInfoResultDTO> getStore();

    List<MiniAppInfoResultDTO> findByUserId(String userId);

    MiniAppInfoDTO getMiniAppInfo(String storeId, String id);

    List<String> getAppVersions(String storeId, String id);

    List<MiniAppInfoDTO> getMiniAppByName(String name);

    Manifest getManifest(String miniappId, String versionId);

    Map<String, Object> getMetadataByVersion(String miniappId, Object versionId);

    Map<String, Object> getMetadata(String miniappId);

    PublicKey getPublicKey();

    MiniAppInfoResultDTO updateDraft(String storeId, String id, MiniAppInfoUpdateDraft miniAppInfo, MultiPartFiles files);

    MiniAppInfoResultDTO publicMiniapp(String storeId, String id, MiniAppInfoUpdate miniAppInfo, MultiPartFiles files);

    MiniAppInfoResultDTO approve(String storeId, String id);

    MiniAppInfoResultDTO reject(String storeId, String id, Reject reject);

    MiniAppInfoResultDTO update(String storeId, String id, MiniAppInfoUpdate miniAppInfo, MultiPartFiles files);

    Void rollBack(String storeId, RollBack rollBack);

    Void delete(String storeId, String id);
}

package com.webconsole.miniappmanager.store.controller;

import com.webconsole.miniappmanager.model.*;
import com.webconsole.miniappmanager.model.dto.MiniAppInfoDTO;
import com.webconsole.miniappmanager.model.dto.MiniAppInfoResultDTO;
import com.webconsole.miniappmanager.model.response.Response;
import com.webconsole.miniappmanager.store.service.MiniAppInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mini-apps")
public class MiniAppController {

    private final MiniAppInfoService miniAppInfoService;

    @GetMapping
    private Response<List<MiniAppInfoResultDTO>> getStore() {
        return Response.ofSucceeded(miniAppInfoService.getMiniApps());
    }

    @GetMapping("/{userId}")
    private Response<List<MiniAppInfoResultDTO>> getStoreByUserId(@PathVariable String userId) {
        return Response.ofSucceeded(miniAppInfoService.findByUserId(userId));
    }

    @GetMapping("/{storeId}/app/{id}")
    private Response<MiniAppInfoDTO> getMiniAppInfo(@PathVariable String storeId, @PathVariable String id) {
        return Response.ofSucceeded(miniAppInfoService.getMiniAppInfo(storeId, id));
    }

    @GetMapping("/{storeId}/app/{id}/versions")
    private Response<List<String>> getAppVersions(@PathVariable String storeId, @PathVariable String id) {
        return Response.ofSucceeded(miniAppInfoService.getMiniAppVersions(storeId, id));
    }

    @GetMapping("/miniapps")
    private Response<List<MiniAppInfoDTO>> getMiniAppByName(@RequestParam(required = false, defaultValue = "") String name) {
        return Response.ofSucceeded(miniAppInfoService.getMiniAppByName(name));
    }

    @GetMapping("/miniapp/{miniappId}/version/{versionId}/manifest")
    private Response<Manifest> getManifest(@PathVariable String miniappId, @PathVariable String versionId) {
        return Response.ofSucceeded(miniAppInfoService.getManifest(miniappId, versionId));
    }

    @GetMapping("/miniapp/{miniappId}/version/{versionId}/metadata")
    private Response<Map<String, Object>> getMetadataByVersion(@PathVariable String miniappId, @PathVariable String versionId) {
        return Response.ofSucceeded(miniAppInfoService.getMetadataByVersion(miniappId, versionId));
    }

    @GetMapping("/miniapp/{miniappId}/metadata")
    private Response<Map<String, Object>> getMetadata(@PathVariable String miniappId) {
        return Response.ofSucceeded(miniAppInfoService.getMetadata(miniappId));
    }

    @GetMapping("/keys/publicKey")
    private Response<PublicKey> getPublicKey() {
        return Response.ofSucceeded(miniAppInfoService.getPublicKey());
    }

    @PutMapping("/{storeId}/app/{id}/draft")
    private Response<MiniAppInfoResultDTO> updateDraft(@Valid MiniAppInfoUpdateDraft miniAppInfo, @PathVariable String id,
                                                       @PathVariable String storeId, MultiPartFiles files) {
        return Response.ofSucceeded(miniAppInfoService.updateDraft(storeId, id, miniAppInfo, files));
    }

    @PutMapping("/{storeId}/app/{id}/public")
    private Response<MiniAppInfoResultDTO> publicMiniapp(@Valid MiniAppInfoUpdate miniAppInfo, @PathVariable String id,
                                                         @PathVariable String storeId, MultiPartFiles files) {
        return Response.ofSucceeded(miniAppInfoService.publicMiniapp(storeId, id, miniAppInfo, files));
    }

    @PutMapping("/{storeId}/app/{id}/approve")
    private Response<MiniAppInfoResultDTO> approve(@PathVariable String id, @PathVariable String storeId) {
        return Response.ofSucceeded(miniAppInfoService.approve(storeId, id));
    }

    @PutMapping("/{storeId}/app/{id}/reject")
    private Response<MiniAppInfoResultDTO> reject(@PathVariable String id, @PathVariable String storeId, @Valid @RequestBody Reject reject) {
        return Response.ofSucceeded(miniAppInfoService.reject(storeId, id, reject));
    }

    @PutMapping("/{storeId}/app/{id}")
    private Response<MiniAppInfoResultDTO> update(@Valid MiniAppInfoUpdate miniAppInfo, @PathVariable String id,
                                                  @PathVariable String storeId, MultiPartFiles files) {
        return Response.ofSucceeded(miniAppInfoService.update(storeId, id, miniAppInfo, files));
    }

    @PutMapping("/{storeId}/rollback")
    private Response<Void> rollBack(@PathVariable String storeId, @RequestBody RollBack rollBack) {
        return Response.ofSucceeded(miniAppInfoService.rollBack(storeId, rollBack));
    }

    @DeleteMapping("/{storeId}/app/{id}")
    private Response<Void> delete(@PathVariable String id, @PathVariable String storeId) {
        return Response.ofSucceeded(miniAppInfoService.delete(storeId, id));
    }
}

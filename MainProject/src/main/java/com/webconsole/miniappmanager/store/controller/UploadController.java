package com.webconsole.miniappmanager.store.controller;

import com.webconsole.miniappmanager.model.AttachmentFile;
import com.webconsole.miniappmanager.model.AttachmentFileDraft;
import com.webconsole.miniappmanager.model.MultiPartFiles;
import com.webconsole.miniappmanager.model.MultiPartFilesDraft;
import com.webconsole.miniappmanager.model.response.Response;
import com.webconsole.miniappmanager.store.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    @PostMapping("upload/{userId}/draft")
    private Response<Void> saveDraft(@PathVariable String userId, AttachmentFileDraft attachmentFile, @Valid MultiPartFilesDraft files) {
        uploadService.saveDraft(userId, attachmentFile, files);
        return Response.ofSucceeded();
    }

    @PostMapping("upload/{userId}/public")
    private Response<Void> uploadPublic(@PathVariable String userId, @Valid AttachmentFile attachmentFile, @Valid MultiPartFiles files) {
        uploadService.upload(userId, attachmentFile, files);
        return Response.ofSucceeded();
    }
}

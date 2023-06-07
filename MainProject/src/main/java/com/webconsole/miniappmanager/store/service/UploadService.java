package com.webconsole.miniappmanager.store.service;

import com.webconsole.miniappmanager.model.AttachmentFile;
import com.webconsole.miniappmanager.model.AttachmentFileDraft;
import com.webconsole.miniappmanager.model.MultiPartFiles;
import com.webconsole.miniappmanager.model.MultiPartFilesDraft;

public interface UploadService {
    void saveDraft(String userId, AttachmentFileDraft attachmentFile, MultiPartFilesDraft files);

    void upload(String userId, AttachmentFile attachmentFile, MultiPartFiles files);
}

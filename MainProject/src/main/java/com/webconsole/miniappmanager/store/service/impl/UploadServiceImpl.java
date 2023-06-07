package com.webconsole.miniappmanager.store.service.impl;

import com.webconsole.miniappmanager.model.AttachmentFile;
import com.webconsole.miniappmanager.model.AttachmentFileDraft;
import com.webconsole.miniappmanager.model.MultiPartFiles;
import com.webconsole.miniappmanager.model.MultiPartFilesDraft;
import com.webconsole.miniappmanager.store.service.UploadService;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public void saveDraft(String userId, AttachmentFileDraft attachmentFile, MultiPartFilesDraft files) {

    }

    @Override
    public void upload(String userId, AttachmentFile attachmentFile, MultiPartFiles files) {

    }
}

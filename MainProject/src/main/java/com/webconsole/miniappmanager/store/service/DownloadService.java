package com.webconsole.miniappmanager.store.service;

import javax.servlet.http.HttpServletResponse;

public interface DownloadService {
    void download(String storeId, String fileId, int mode, HttpServletResponse response) throws Exception;

    void downloadFileById(String fileId, HttpServletResponse response) throws Exception;
}

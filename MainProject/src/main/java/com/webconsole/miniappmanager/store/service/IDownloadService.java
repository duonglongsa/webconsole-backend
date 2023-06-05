package com.webconsole.miniappmanager.store.service;

import javax.servlet.http.HttpServletResponse;

public interface IDownloadService {
    void download(HttpServletResponse response, String storeId, String fileId, int mode) throws Exception;

    void downloadFileById(HttpServletResponse response, String fileId) throws Exception;
}

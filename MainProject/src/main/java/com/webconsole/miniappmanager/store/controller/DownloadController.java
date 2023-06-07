package com.webconsole.miniappmanager.store.controller;

import com.webconsole.miniappmanager.store.service.IDownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class DownloadController {

    private final IDownloadService downloadService;

    @GetMapping("download/{storeId}/app/{id}")
    private void download(@PathVariable String storeId, @PathVariable String id, HttpServletResponse
            response, @RequestParam(defaultValue = "0") int mode) throws Exception {
        downloadService.download(response, storeId, id, mode);
    }

    @GetMapping("files/{id}")
    private void getFile(@PathVariable String id, HttpServletResponse response) throws Exception {
        downloadService.downloadFileById(response, id);
    }
}

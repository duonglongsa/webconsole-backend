package com.webconsole.miniappmanager.store.controller;

import com.webconsole.miniappmanager.store.service.DownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/download")
public class DownloadController {

    private final DownloadService downloadService;

    @GetMapping("/{storeId}/app/{id}")
    private void downloadFileFromStore(@PathVariable String storeId, @PathVariable String id,
                                       @RequestParam(defaultValue = "0") int mode, HttpServletResponse response) throws Exception {
        downloadService.download(storeId, id, mode, response);
    }

    @GetMapping("/files/{id}")
    private void downloadFile(@PathVariable String id, HttpServletResponse response) throws Exception {
        downloadService.downloadFileById(id, response);
    }
}

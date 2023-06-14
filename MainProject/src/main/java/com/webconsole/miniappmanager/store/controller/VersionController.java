package com.webconsole.miniappmanager.store.controller;

import com.webconsole.miniappmanager.model.response.Response;
import com.webconsole.miniappmanager.store.entity.Version;
import com.webconsole.miniappmanager.store.service.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/versions")
public class VersionController {
    private final VersionService versionService;

    @GetMapping
    private Response<List<Version>> getStore() {
        return Response.ofSucceeded(versionService.getVersions());
    }

    @PostMapping
    private Response<Version> create() {
        return Response.ofSucceeded(versionService.create());
    }
}

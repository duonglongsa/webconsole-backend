package com.webconsole.miniappmanager.store.service.impl;

import com.webconsole.miniappmanager.store.entity.Version;
import com.webconsole.miniappmanager.store.repository.VersionRepository;
import com.webconsole.miniappmanager.store.service.VersionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VersionServiceImpl implements VersionService {
    private final VersionRepository versionRepository;

    @Override
    public List<Version> getVersions() {
        return versionRepository.findAll();
    }

    @Override
    public Version create() {
        var version = new Version().setX(1).setY(1).setZ(1);
        return versionRepository.save(version);
    }
}

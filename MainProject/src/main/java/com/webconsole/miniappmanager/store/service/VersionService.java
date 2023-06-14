package com.webconsole.miniappmanager.store.service;

import com.webconsole.miniappmanager.store.entity.Version;

import java.util.List;

public interface VersionService {
    List<Version> getVersions();

    Version create();
}

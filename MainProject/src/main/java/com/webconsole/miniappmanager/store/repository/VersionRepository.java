package com.webconsole.miniappmanager.store.repository;

import com.webconsole.miniappmanager.store.entity.Version;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VersionRepository extends MongoRepository<Version, String> {
}

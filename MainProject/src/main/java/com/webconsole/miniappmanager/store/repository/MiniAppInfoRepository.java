package com.webconsole.miniappmanager.store.repository;

import com.webconsole.miniappmanager.store.entity.MiniAppInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MiniAppInfoRepository extends MongoRepository<MiniAppInfo, String> {
}

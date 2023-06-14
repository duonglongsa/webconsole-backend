package com.webconsole.miniappmanager.store.repository;

import com.webconsole.miniappmanager.store.entity.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {
}

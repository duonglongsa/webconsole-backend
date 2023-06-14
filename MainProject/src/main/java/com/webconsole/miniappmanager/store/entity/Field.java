package com.webconsole.miniappmanager.store.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document("field")
public class Field {
    @Id
    private String fieldId;
    private String fieldName;
    private String pathName;
    private String appTypeId;
}

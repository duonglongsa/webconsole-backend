package com.webconsole.miniappmanager.store.entity;

import com.webconsole.miniappmanager.model.Organization;
import lombok.Data;

import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document("store")
public class UserInfo {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private Organization organization;
    private boolean root;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}

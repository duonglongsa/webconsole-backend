package com.webconsole.miniappmanager.model;

import lombok.Data;

import java.util.List;

@Data
public class Manifest {
    private List<String> manifest;
    private String signature;
    private boolean root;
}

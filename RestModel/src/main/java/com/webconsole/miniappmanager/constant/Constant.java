package com.webconsole.miniappmanager.constant;

public class Constant {
    public static final String PREFIX_RESPONSE_CODE;
    public static final String SYSTEM_USER = "system";

    static {
        PREFIX_RESPONSE_CODE = System.getProperty("web-console.response.prefix-code", "WCS-");
    }

    private Constant() {
        throw new UnsupportedOperationException();
    }
}

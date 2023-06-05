package com.webconsole.miniappmanager.utils.constants;

public class Message {
    public static class Error {
        public static final String NOT_FOUND = "{} not found";
        public static final String EXIST = "already exist {}";
        public static final String UPLOAD_FAILED = "Upload miniapp failed by {}";
        public static final String UPDATE_FAILED = "Update miniapp failed {}";
        public static final String DELETE_FAILED = "Delete miniapp failed {}";
        public static final String LAST_VERSION = "Not latest version";
        public static final String FILE_MANIFEST_NOT_EXIST = "File manifest is not exist";
    }

    public static class Warning {
        public static final String FILE_ZIP_NULL = "Please choose file zip";
        public static final String FILE_NULL = "Please choose file";
        public static final String FILE_ICON_NULL = "Please choose file icon";
        public static final String FILE_APP_NULL = "Please choose file miniapp (.zip)";
        public static final String FILE_BANNER_NULL = "Please choose file banner";
        public static final String FILE_INVALID = "file {} is invalid";
        public static final String VERSION_INVALID = "The version must be larger than the previous version";
        public static final String PACKAGE_ID_INVALID = "PackageId is not match";

        public static final String FILE_ICON_INVALID = "Icon is invalid";
        public static final String FILE_BANNER_INVALID = "Banner is invalid";
    }

    public static final String UPDATE_MINIAPP_SUCCESS = "Update miniapp info success ";
    public static final String STATUS_NOT_DRAFT = "Status is not draft ";
    public static final String UPLOAD_FAILED = "Upload failed ! ";
    public static final String START_UPDATE_MINIAPP  = "Start update miniapp info ";
    public static final String UPDATE_FAILED  = "Update miniapp failed !";

    public static final String GET_DATA_SUCCESS  = "Get data success";
    public static final String GET_DATA_FAILED  = "Get data failed!";

}

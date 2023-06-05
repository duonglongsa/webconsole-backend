//package com.webconsole.miniappmanager.store.request;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import vn.com.mbbank.miniappmanager.store.config.CoreFeignAuthUploadServiceConfiguration;
//import vn.com.mbbank.miniappmanager.store.model.AccessTokenStore;
//
///**
// * @author tientv2.os
// * @desciption Upload file request authentication
// * @date 24/3/2022
// */
//@FeignClient(name = "auth-store", url = "${store.auth-url}", configuration = CoreFeignAuthUploadServiceConfiguration.class)
//public interface AuthUploadFileRequest {
//
//    @RequestMapping(method = RequestMethod.POST, value = "?grant_type=client_credentials")
//    AccessTokenStore getToken();
//}

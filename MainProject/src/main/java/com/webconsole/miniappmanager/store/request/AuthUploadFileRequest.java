//package com.webconsole.miniappmanager.store.request;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import vn.com.mbbank.miniappmanager.store.config.CoreFeignAuthUploadServiceConfiguration;
//import vn.com.mbbank.miniappmanager.store.model.AccessTokenStore;
//
//@FeignClient(name = "auth-store", url = "${store.auth-url}", configuration = CoreFeignAuthUploadServiceConfiguration.class)
//public interface AuthUploadFileRequest {
//
//    @RequestMapping(method = RequestMethod.POST, value = "?grant_type=client_credentials")
//    AccessTokenStore getToken();
//}

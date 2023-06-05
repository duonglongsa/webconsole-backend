//package com.webconsole.miniappmanager.store.request;
//
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import vn.com.mbbank.common.base.ResponseData;
//import vn.com.mbbank.microservicebiz.file.response.FileResponse;
//import vn.com.mbbank.miniappmanager.config.MultipartSupportConfig;
//import vn.com.mbbank.miniappmanager.response.HttpResponse;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestPart;
//import vn.com.mbbank.miniappmanager.config.CoreFeignConfiguration;
//
//
//import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
//
//@FeignClient(name = "store", url = "${store.base-url}", configuration = { CoreFeignConfiguration.class, MultipartSupportConfig.class})
//public interface UploadFileRequest {
//
//    @RequestMapping(method = RequestMethod.POST, value = "/files", consumes = MULTIPART_FORM_DATA_VALUE)
//    ResponseData<HttpResponse<FileResponse>> uploadFile(
//            @RequestHeader("ClientMessageId") String clientMessageId,
//            @RequestHeader("RefNo") String refNo,
////            @RequestParam("createdBy") String createdBy,
//////            @RequestParam("description") String description,
//////            @RequestParam("docCode") String docCode,
//////            @RequestParam("docType") String docType,
//////            @RequestParam("expiredDate") String expiredDate,
//////            @RequestParam("serviceName") String serviceName,
//////            @RequestParam("state") String state,
////            @RequestParam @ModelAttribute UploadFile uploadFile,
//            @RequestParam MultiValueMap<String, String> params,
//            @RequestPart("file") MultipartFile file,
//            @RequestHeader("Authorization") String authorization);
//
//    @RequestMapping(method = RequestMethod.GET, value = "/files/{id}")
//    HttpResponse<HttpResponse<FileResponse>> getById(
//            @RequestHeader("ClientMessageId") String clientMessageId,
//            @RequestHeader("RefNo") String refNo,
//            @PathVariable("id") String id,
//            @RequestHeader("Authorization") String authorization);
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/files/{id}")
//    void update(
//            @PathVariable("id") String id,
//            @RequestHeader("Authorization") String authorization);
//
//    @RequestMapping(method = RequestMethod.GET, value = "/files/{serviceName}/{id}", consumes = "application/octet-stream")
//    byte[] download(
//            @PathVariable("serviceName") String serviceName,
//            @PathVariable("id") String id,
//            @RequestHeader("Authorization") String authorization);
//
//}

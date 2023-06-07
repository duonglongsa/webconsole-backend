package com.webconsole.miniappmanager.store.service.impl;

import com.webconsole.miniappmanager.constants.AppStatus;
import com.webconsole.miniappmanager.model.MiniappDownload;
import com.webconsole.miniappmanager.store.entity.Store;
import com.webconsole.miniappmanager.store.service.FileService;
import com.webconsole.miniappmanager.store.service.IDownloadService;
import com.webconsole.miniappmanager.utils.Utils;
import com.webconsole.miniappmanager.utils.constants.Message;
import com.webconsole.miniappmanager.utils.constants.Properties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@Slf4j
@RequiredArgsConstructor
public class DownloadServiceImpl implements IDownloadService {
    private final FileService fileService;

    private final MongoTemplate mongoTemplate;

    private final ServletContext servletContext;

    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${file-path}")
    private String filePath;

    @Override
    public void download(HttpServletResponse response, String storeId, String id, int mode) throws Exception {
        log.info("Start download miniapp " + id);
        MiniappDownload miniAppInfo = getMiniappInfoDraft(storeId, id);
        if (miniAppInfo == null) {
            try {
                Aggregation aggregation = Aggregation.newAggregation(match(where(Properties.ID).is(storeId)), unwind(Properties.MINI_APPS), unwind(Properties.APP_VERSIONS), context -> new Document("$addFields", new Document().append("result", new Document().append("$eq", Arrays.asList(Properties.MINI_APPS_OBJ.VERSION_LIVE_$, Properties.MINI_APPS_OBJ.VERSION_$)))), match(where("result").is(true)), match(where(Properties.MINI_APPS_OBJ.APP_ID_PROP).is(id)), project().andExpression(Properties.MINI_APPS_OBJ.FILE_ID_$).as(Properties.FILE_ID).andExpression(Properties.MINI_APPS_OBJ.FULL_NAME_$).as(Properties.FULL_NAME));
                AggregationResults<MiniappDownload> results = mongoTemplate.aggregate(aggregation, Properties.STORE, MiniappDownload.class);
                if (results.getMappedResults().isEmpty()) {
                    log.error(Message.Error.NOT_FOUND.replace("{}", "Miniapp"));
                    throw new Exception("Mini app not found");
                }
                miniAppInfo = results.getMappedResults().get(0);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(Message.GET_DATA_FAILED);
                throw new Exception(Message.GET_DATA_FAILED);
            }
        }
        String saveFileFolderPath = filePath.replace("{}", id);
        byte[] fileByte = fileService.download(serviceName, miniAppInfo.getFileId());
        File file = new File(saveFileFolderPath + miniAppInfo.getFullName());
        Utils.setFileData(file, saveFileFolderPath, fileByte);

        MediaType mediaType = getMediaType(file.getName());
        response.setContentType(mediaType.getType());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName());
        response.setContentLength((int) file.length());

        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(file)); BufferedOutputStream os = new BufferedOutputStream(response.getOutputStream())) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            if (mode == 1) {
                sumNumberOfDownload(storeId, id);
            }
            os.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new Exception("Download failed");
        } finally {
            Path path = Paths.get(saveFileFolderPath);
            if (Files.exists(path)) {
                FileUtils.deleteDirectory(new File(saveFileFolderPath));
            }
        }
    }

    private void sumNumberOfDownload(String storeId, String id) {
        Query query = new Query();
        query.addCriteria(where(Properties.ID).is(storeId)).addCriteria(where(Properties.MINI_APPS_OBJ.APP_ID_PROP).is(id));
        Update update = new Update();
        update.inc(Properties.MINI_APPS_OBJ.NUMBER_OF_DOWNLOAD_$, 1);
        this.mongoTemplate.updateFirst(query, update, Store.class);
    }

    @Override
    public void downloadFileById(HttpServletResponse response, String fileId) throws Exception {
        var fileInfo = fileService.getById(Utils.genUniqueId(), fileId);
        if (fileInfo == null) {
            log.error("File not found id: {}", fileId);
            throw new Exception("Download file failed");
        }
        String saveFileFolderPath = filePath.replace("{}", fileId);
        byte[] fileByte = fileService.download(serviceName, fileId);
        File file = new File(saveFileFolderPath + fileInfo.getFileName());
        Utils.setFileData(file, saveFileFolderPath, fileByte);

        MediaType mediaType = getMediaType(file.getName());
        response.setContentType(mediaType.getType());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName());
        response.setContentLength((int) file.length());
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(file)); BufferedOutputStream os = new BufferedOutputStream(response.getOutputStream())) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new Exception("Download file failed");
        } finally {
            Path path = Paths.get(saveFileFolderPath);
            if (Files.exists(path)) {
                FileUtils.deleteDirectory(new File(saveFileFolderPath));
            }
        }
    }

    private MediaType getMediaType(String fileName) {
        MediaType mediaType;
        String mineType = servletContext.getMimeType(fileName);
        try {
            mediaType = MediaType.parseMediaType(mineType);
        } catch (Exception e) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }
        return mediaType;
    }

    private MiniappDownload getMiniappInfoDraft(String storeId, String appId) throws Exception {
        try {
            Aggregation aggregation = Aggregation.newAggregation(match(where(Properties.ID).is(storeId)), unwind(Properties.MINI_APPS), unwind(Properties.APP_VERSIONS), match(where(Properties.MINI_APPS_OBJ.APP_ID_PROP).is(appId)), match(where(Properties.MINI_APPS_OBJ.STATUS).in(List.of(AppStatus.DRAFT, AppStatus.IN_REVIEW, AppStatus.REJECT))), project().andExpression(Properties.MINI_APPS_OBJ.FILE_ID_$).as(Properties.FILE_ID).andExpression(Properties.MINI_APPS_OBJ.FULL_NAME_$).as(Properties.FULL_NAME));
            AggregationResults<MiniappDownload> results = mongoTemplate.aggregate(aggregation, Properties.STORE, MiniappDownload.class);
            if (results.getMappedResults().isEmpty()) {
                return null;
            }
            return results.getMappedResults().get(0);
        } catch (Exception e) {
            throw new Exception(Message.GET_DATA_FAILED);
        }
    }
}

package com.webconsole.miniappmanager.model;

import com.webconsole.miniappmanager.utils.constants.Message;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class MultiPartFilesDraft {
    @NotNull(message = Message.Warning.FILE_APP_NULL)
    private MultipartFile app;
    private MultipartFile iconFile;
    private MultipartFile[] promotionalImageFiles;
    private MultipartFile bannerFile;
}

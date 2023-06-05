package com.webconsole.miniappmanager.model;

import com.webconsole.miniappmanager.utils.constants.Message;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class MultiPartFiles {
    @NotNull(message = Message.Warning.FILE_APP_NULL)
    private MultipartFile app;
    @NotNull(message = Message.Warning.FILE_ICON_NULL)
    private MultipartFile iconFile;
    private MultipartFile[] promotionalImageFiles;
    @NotNull(message = Message.Warning.FILE_BANNER_NULL)
    private MultipartFile bannerFile;
}

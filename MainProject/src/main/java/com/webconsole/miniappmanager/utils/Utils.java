package com.webconsole.miniappmanager.utils;

import com.webconsole.miniappmanager.store.entity.Version;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

public class Utils {

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String convertVersionToString(Version version) {
        return version.getX() + "." + version.getY() + "." + version.getZ();
    }

    public static Version convertStringToVersion(String versionStr) {
        String[] arr = versionStr.split("");
        String x = "";
        String y = "";
        String z = "";
        int dotOrder = 0;
        for (String str : arr) {
            if (str.equals(".")) {
                dotOrder++;
                continue;
            }
            switch (dotOrder) {
                case 0 -> x += str;
                case 1 -> y += str;
                case 2 -> z += str;
                default -> {
                }
            }
        }

        Version version = new Version();
        version.setX(Integer.parseInt(x));
        version.setY(Integer.parseInt(y));
        version.setZ(Integer.parseInt(z));

        return version;
    }

    public static void convertToFile(File file, MultipartFile multipartFile) {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MultipartFile convertFileToMultipartFile(File fileZip, String contentType) throws IOException {
        InputStream stream =  new FileInputStream(fileZip);
        return new MockMultipartFile("file", fileZip.getName(), contentType, stream);
    }

    public static void setFileData(File file, String filePath, byte[] data) throws IOException{
        Path path = Paths.get(filePath);
        if(!Files.exists(path)) {
            File dir = new File(filePath);
            dir.mkdirs();
        }
        try(OutputStream os = new FileOutputStream(file)) {
            os.write(data);
        }
    }

    public static String readFileData(File file) {
        StringBuilder data = new StringBuilder();
        try (FileReader fr = new FileReader(file)) {
            int i;
            while ((i = fr.read()) != -1) {
                data.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    public static String genUniqueId() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String getFileExtension(String fullName) {
        if(fullName == null || fullName.isBlank()) {
            return "";
        }
        int dotIndex = fullName.lastIndexOf(".");
        return (dotIndex == -1) ? "" : fullName.substring(dotIndex + 1);
    }

    public static boolean fileIsNull(MultipartFile file) {
        return (file == null || Objects.requireNonNull(file.getOriginalFilename()).isBlank());
    }
}

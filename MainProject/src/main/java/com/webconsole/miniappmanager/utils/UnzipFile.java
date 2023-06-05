package com.webconsole.miniappmanager.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Slf4j
public class UnzipFile {

    public static void unzip(String fileZipPath, String dirPath) throws IOException{
        File destDir = new File(dirPath);
        if (!destDir.mkdir()) {
            destDir.mkdirs();
        }
        byte[] buffer = new byte[1024];
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZipPath))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                Pattern pattern = Pattern.compile("^[$&+,:;=?@#|'<>.^*()%!_-]|\\/[$&+,:;=?@#|'<>.^*()%!_-]|(.map)$", Pattern.MULTILINE);
                Matcher matcher = pattern.matcher(zipEntry.getName());
                if(matcher.find()) {
                    zipEntry = zis.getNextEntry();
                    continue;
                }
                File newFile = newFile(destDir, zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    // fix for Windows-created archives
                    File parent = newFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }

                    // write file content
                    try(FileOutputStream fos = new FileOutputStream(newFile)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        }

    }

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }
        return destFile;
    }

}

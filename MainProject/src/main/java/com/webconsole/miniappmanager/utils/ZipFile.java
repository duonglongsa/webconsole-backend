package com.webconsole.miniappmanager.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
public class ZipFile {

    public static List<String> filesListInDir = new ArrayList<>();

    public static boolean zipDirectory(String dirPath, String zipDirName) {
        filesListInDir = new ArrayList<>();
        File dir = new File(dirPath);
        populateFilesList(dir);
        try(
                FileOutputStream fos = new FileOutputStream(zipDirName);
                ZipOutputStream zos = new ZipOutputStream(fos)
        ) {
            for(String filePath : filesListInDir){
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);
                try( FileInputStream fis = new FileInputStream(filePath)) {
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                    zos.closeEntry();
                }
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public static void populateFilesList(File dir) {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
            else populateFilesList(file);
        }
    }
}

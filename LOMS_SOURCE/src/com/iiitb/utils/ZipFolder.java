/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iiitb.utils;

/**
 *
 * @author ARUN
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFolder {

    public ZipFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;

        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);

        //addFolderToZip("", srcFolder, zip);
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {           
            addFileToZip("", srcFolder + "/" + fileName, zip);           
        }
        zip.flush();
        zip.close();
        fileWriter.close();
    }

    static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
            throws Exception {

       File folder = new File(srcFile);
        if (folder.isDirectory()) {
            addFolderToZip(path, srcFile, zip);
        } else {
            byte[] buf = new byte[1024];
            int len;
            FileInputStream in = new FileInputStream(srcFile);

            if (path.equals("")) {
                zip.putNextEntry(new ZipEntry(folder.getName()));
            } else {
                zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
            }
            while ((len = in.read(buf)) > 0) {
                zip.write(buf, 0, len);
            }
            in.close();
        }
    }

    static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
            throws Exception {

        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
            if (path.equals("")) {
                addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
            } else {
                addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
            }
        }
    }
}
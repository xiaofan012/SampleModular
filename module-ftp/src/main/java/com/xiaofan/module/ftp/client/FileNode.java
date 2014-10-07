/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xiaofan.module.ftp.client;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Administrator
 */
public class FileNode {
    
    
    private File file;

    public FileNode(File file) {
        this.file = file;
    }

    public FileNode(String fileName) {
        file = new File(fileName);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        
//        showBasicAttr(file);
        if (file == null) {
            return "NULL";
        }
        if (file.isFile()) {
            return file.getName();
        }
        if (file.isDirectory()) {
            return FileSystemView.getFileSystemView().getSystemDisplayName(file);
        }

        return null;
    }
    
}

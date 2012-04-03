/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iiitb.utils;

import java.io.File;

/**
 *
 * @author ARUN
 */
public class LOMSCustomFilter extends javax.swing.filechooser.FileFilter{

    private String extensions[];
    private String description;
                
    
    public LOMSCustomFilter() {
        
    }
            

    public LOMSCustomFilter(String description, String extension) {
        this(description, new String[]{extension});
    }

    public LOMSCustomFilter(String description, String extensions[]) {
        this.description = description;
        this.extensions = (String[]) extensions.clone();
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        int count = extensions.length;
        String path = file.getAbsolutePath();
        for (int i = 0; i < count; i++) {
            String ext = extensions[i];
            if (path.endsWith(ext)
                    && (path.charAt(path.length() - ext.length()) == '.')) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return (description == null ? extensions[0] : description);
    }
}

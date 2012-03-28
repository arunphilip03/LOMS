/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iiitb.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author ARUN
 */
public class LOMSProperties {

    public String getTempDirectory() {
        Properties prop = new Properties();
        try {

            FileInputStream in = new FileInputStream("LOMSProperties.properties");
            prop.load(in);
            System.out.println(prop.getProperty("tempDirectoryPath"));
            in.close();
        } catch (Exception ex) {
            System.err.println("Error reading the properties file");
        }
        return prop.getProperty("tempDirectoryPath");

    }
    
    public void setTempDirectory(String tempDirValue) {
        Properties prop = new Properties();
        try {                    
            FileOutputStream out = new FileOutputStream("LOMSProperties.properties");
            System.out.println(tempDirValue);
            prop.setProperty("tempDirectoryPath", tempDirValue);
            prop.store(out, null);
            out.close();
        } catch (Exception ex) {
            System.err.println("Error reading the properties file");
        }
        
    }
}

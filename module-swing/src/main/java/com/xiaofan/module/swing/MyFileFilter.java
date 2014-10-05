/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xiaofan.module.swing;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * 在JFileChooser中可被接受的文件.
 * 
 * 使用方式<br>
 * <pre>
 * JFileChooser fileChooser = new JFileChooser();
 * fileChooser.addChoosableFileFilter( new MyFileFilter("java") );
 * fileChooser.addChoosableFileFilter( new MyFileFilter("class") );
 * fileChooser.showOpenDialog(this);
 * </pre>
 * 
 * @author Administrator
 */
public class MyFileFilter extends FileFilter {
    private String ext ;
    /**
     * @param ext 
     */
    public MyFileFilter( String ext ){
        this.ext = ext.toUpperCase() ;
    }
    
    @Override
    public boolean accept(File file) {
        if( file.isDirectory() ){
            return true;
        }
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        if( index > 0 && index < fileName.length() ){
            String extension = fileName.substring(index + 1 ).toUpperCase();
            if( ext.equals( extension )){
                return true ;
            }
        }
        
        return false ;
    }

    @Override
    public String getDescription() {
        if( "JAVA".equals(ext)){
            return "Java Source File : *.java";
        }
        if( "CLASS".equals(ext)){
            return "Java Class File : *.class";
        }
        return "";
    }
    
}

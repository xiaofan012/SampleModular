package com.xiaofan.module.ftp.client;

import java.io.File;
import java.io.IOException;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPException;

/**
 * 向服务器上传文件或文件夹
 * 
 * @author Administrator
 * @date Oct 2, 2014 11:04:02 PM 
 * @version V1.0.0
 */
public class FtpUpload {
	
	private FTPClient ftpClient ;
	
	/**
	 * @param ftpClient
	 */
	public FtpUpload( FTPClient ftpClient ){
		this.ftpClient = ftpClient ;
	}
	
	/**
	 * 上传文件
	 * @param name 本地待上传文件名,包含路径信息
	 * @throws FTPException 
	 * @throws IOException 
	 */
	public void uploadFile(String name) throws IOException, FTPException{
		String fileName = name.substring( name.lastIndexOf("\\") + 1 );
		ftpClient.put(name, fileName);
	}
	
	/**
	 * 上传文件夹
	 * 
	 * @param dir 文件夹
	 * @throws FTPException 
	 * @throws IOException 
	 */
	public void uploadDir( String dir) throws IOException, FTPException{
		String dirName = dir.substring( dir.lastIndexOf("\\") + 1 );
		ftpClient.mkdir( dirName );
		
		String currentDir = ftpClient.pwd();
		ftpClient.chdir( dirName );
		
		String[] subFileNames = this.getLocalDirList( dir );
		for( int i=0; i<subFileNames.length; i++ ){
			String tempPath = dir + "\\" + subFileNames[i];
			File tempFile = new File( tempPath );
			if( tempFile.isFile() ){
				this.uploadFile( tempPath );
			}
			else if( tempFile.isDirectory() ){
				this.uploadDir( tempPath );
			}
		}
		
		//切回当前文件夹
		ftpClient.chdir( currentDir );
	}
	
	/**
	 * 获取本地文件夹下的文件
	 * 
	 * @param localPath 本地文件夹路径
	 * @return String[] 文件数组
	 */
	public String[] getLocalDirList( String localPath ){
		File file = new File( localPath );
		String[] subFileNames = file.list();
		return subFileNames;
	}
	
}

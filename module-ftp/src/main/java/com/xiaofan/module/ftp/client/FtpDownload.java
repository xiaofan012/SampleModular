package com.xiaofan.module.ftp.client;

import java.io.File;
import java.io.IOException;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPException;

/**
 * 从服务器下载文件或文件夹
 * 
 * @author Administrator
 * @date Oct 2, 2014 11:04:36 PM 
 * @version V1.0.0
 */
public class FtpDownload {
	private FTPClient ftpClient ;
	
	public FtpDownload( FTPClient ftpClient ){
		this.ftpClient = ftpClient ;
	}
	
	/**
	 * 从FTP服务器下载文件
	 * 
	 * @param localPath	本地保存路径
	 * @param remoteFile FTP服务器上的文件
	 * @throws FTPException 
	 * @throws IOException 
	 */
	public void downloadFile( String localPath, String remoteFile ) throws IOException, FTPException{
		ftpClient.get(localPath, remoteFile);
	}
	
	/**
	 * 从FTP服务器下载文件夹
	 * 
	 * @param localPath 本地保存路径
	 * @param remoteDir FTP服务器上的文件夹
	 * @throws IOException
	 * @throws FTPException
	 */
	public void downloadDir( String localPath, String remoteDir ) throws IOException, FTPException{
		String[] subFileNames = ftpClient.dir( remoteDir, true );
		ftpClient.chdir( remoteDir );
		String localDirName = localPath + "\\" + remoteDir ;
		File localDir = new File( localDirName );
		localDir.mkdir();
		for( int i=1; i<subFileNames.length; i++ ){
			int lastIndex = subFileNames[i].lastIndexOf(":");
			subFileNames[i] = subFileNames[i].substring( lastIndex + 4 );
			if( subFileNames[i] == null || ".".equals(subFileNames[i]) || "..".equals( subFileNames[i] ) ){
				continue;
			}
			else if( subFileNames[i].indexOf(".") == -1 ){
				this.downloadDir(localDirName, subFileNames[i]);
			}
			else{
				this.downloadFile(localDirName, subFileNames[i] );
			}
		}
		ftpClient.cdup();
	}
	
}

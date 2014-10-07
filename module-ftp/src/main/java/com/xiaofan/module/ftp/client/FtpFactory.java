package com.xiaofan.module.ftp.client;

import java.io.IOException;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;

/**
 * Ftp工厂类，用于创建以及关闭连接
 * 
 * @author Administrator
 * @date Oct 2, 2014 10:37:53 PM 
 * @version V1.0.0
 */
public class FtpFactory {
	
	private String ftpHost;
	private String ftpUser;
	private String ftpPass;
	
	private FTPClient ftpClient ;
	
	/**
	 * @param ftpHost 远程FTP主机地址
	 * @param ftpUser FTP用户名
	 * @param ftpPass FTP密码
	 */
	public FtpFactory( String ftpHost, String ftpUser, String ftpPass){
		this.ftpHost = ftpHost;
		this.ftpUser = ftpUser;
		this.ftpPass = ftpPass;
	}
	
	/**
	 * 获取连接客户端
	 * 
	 * @return
	 * @throws IOException
	 * @throws FTPException
	 */
	public FTPClient getLoginedFtpClient( String ftpHost, String ftpUser, String ftpPass ) throws IOException, FTPException{
		if( this.ftpClient == null ){
			//TO-DO ...
			ftpClient = new FTPClient();
			ftpClient.setConnectMode( FTPConnectMode.PASV );
		}
		if( ftpClient.connected() == false ){
			ftpClient.setRemoteHost( ftpHost );
			ftpClient.connect();
			ftpClient.login( ftpUser, ftpPass );
		}
		
		return ftpClient ;
	}
	
	/**'
	 * 关闭FTPClient
	 * 
	 * @param ftpClient
	 * @throws IOException
	 * @throws FTPException
	 */
	public static void closeFtpClient( FTPClient ftpClient ) throws IOException, FTPException{
		if( ftpClient != null || ftpClient.connected() ){
			ftpClient.quit();
			ftpClient = null;
		}
	}
}

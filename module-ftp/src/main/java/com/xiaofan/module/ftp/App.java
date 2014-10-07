package com.xiaofan.module.ftp;

import java.io.IOException;
import java.util.Arrays;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String ANONYMOUS = "anonymous";
	
    public static void main( String[] args )
    {
        FTPClient client = new FTPClient();
//        client.setConnectMode( FTPConnectMode.ACTIVE );
        
        String ftpHost = "ftp.pku.edu.cn";
        try {
			client.setRemoteHost(ftpHost);
			client.connect();
			
			//匿名登录
			client.login( ANONYMOUS, null);
			
			//当前目录
			System.out.println("pwd : " + client.pwd());
			
			//只是列出文件
			String[] f1 = client.dir( client.pwd(), false );
			System.out.println( Arrays.toString( f1 ) );
			
			//包含读写等权限信息
//			String[] f2 = client.dir( client.pwd(), true );
//			System.out.println( Arrays.toString( f2 ) );
			
			Thread.sleep(5000);
			
			client.chdir("open");
			System.out.println( client.pwd() );
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FTPException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}

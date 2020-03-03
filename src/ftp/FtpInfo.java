package ftp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpInfo
{
	/**
	 * ��ȡFTPClient����
	 * 
	 * @param ftpHost
	 *            FTP����������
	 * @param ftpPassword
	 *            FTP ��¼����
	 * @param ftpUserName
	 *            FTP��¼�û���
	 * @param ftpPort
	 *            FTP�˿� Ĭ��Ϊ21
	 * @return
	 */
	public static FTPClient getFTPClient(String ftpHost, String ftpUserName,
			String ftpPassword, int ftpPort)
	{
		FTPClient ftpClient = new FTPClient();
		try
		{
			ftpClient = new FTPClient();
			ftpClient.connect(ftpHost, ftpPort);// ����FTP������
			ftpClient.login(ftpUserName, ftpPassword);// ��½FTP������
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode()))
			{
				System.out.println("δ���ӵ�FTP���û������������");
				ftpClient.disconnect();
			} else
			{
				System.out.println("FTP���ӳɹ���");
			}
		} catch (SocketException e)
		{
			e.printStackTrace();
			System.out.println("FTP��IP��ַ���ܴ�������ȷ���á�");
		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("FTP�Ķ˿ڴ���,����ȷ���á�");
		}
		return ftpClient;
	}

	/*
	 * ��FTP�����������ļ�
	 * 
	 * @param ftpHost FTP IP��ַ
	 * 
	 * @param ftpUserName FTP �û���
	 * 
	 * @param ftpPassword FTP�û�������
	 * 
	 * @param ftpPort FTP�˿�
	 * 
	 * @param ftpPath FTP���������ļ�����·�� ��ʽ�� ftptest/aa
	 * 
	 * @param localPath ���ص����ص�λ�� ��ʽ��H:/download
	 * 
	 * @param fileName �ļ�����
	 */
	public static void downloadFtpFile(String ftpHost, String ftpUserName,
			String ftpPassword, int ftpPort, String ftpPath, String localPath,
			String fileName)
	{

		FTPClient ftpClient = null;

		try
		{
			ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
			ftpClient.setControlEncoding("UTF-8"); // ����֧��
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			ftpClient.changeWorkingDirectory(ftpPath);

			File localFile = new File(localPath + File.separatorChar + fileName);
			OutputStream os = new FileOutputStream(localFile);
			ftpClient.retrieveFile(fileName, os);
			os.close();
			ftpClient.logout();

		} catch (FileNotFoundException e)
		{
			System.out.println("û���ҵ�" + ftpPath + "�ļ�");
			e.printStackTrace();
		} catch (SocketException e)
		{
			System.out.println("����FTPʧ��.");
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("�ļ���ȡ����");
			e.printStackTrace();
		}

	}

	/**
	 * Description: ��FTP�������ϴ��ļ�
	 * 
	 * @param ftpHost
	 *            FTP������hostname
	 * @param ftpUserName
	 *            �˺�
	 * @param ftpPassword
	 *            ����
	 * @param ftpPort
	 *            �˿�
	 * @param ftpPath
	 *            FTP���������ļ�����·�� ��ʽ�� ftptest/aa
	 * @param fileName
	 *            ftp�ļ�����
	 * @param input
	 *            �ļ���
	 * @return �ɹ�����true�����򷵻�false
	 */
	public static boolean uploadFile(String ftpHost, String ftpUserName,
			String ftpPassword, int ftpPort, String ftpPath, String fileName,
			InputStream input)
	{
		boolean success = false;
		FTPClient ftpClient = null;
		try
		{
			int reply;
			ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
			reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply))
			{
				ftpClient.disconnect();
				return success;
			}
			ftpClient.setControlEncoding("UTF-8"); // ����֧��
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			ftpClient.changeWorkingDirectory(ftpPath);

			ftpClient.storeFile(fileName, input);

			input.close();
			ftpClient.logout();
			success = true;
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (ftpClient.isConnected())
			{
				try
				{
					ftpClient.disconnect();
				} catch (IOException ioe)
				{
				}
			}
		}
		return success;
	}

	int a;
	double b;
	boolean c;
	char d;
	float f;
	byte e;
	long h;
	short j;

	public static void main(String args[])
	{
		Integer a = new Integer(123);
		Integer b = new Integer(123);
		// new ʵ��֮��ıȽϣ���Ϊ�ֱ𴴽��Ķ������н��Ϊfalse
		System.out.println(a == b);
	}
}

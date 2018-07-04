package org.qidian.utils;

import java.io.File;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * 
 * @Project: TiantianWen jdk :　http://developer.qiniu.com/docs/v6/sdk/java-sdk.html
 * @Description: 依赖包：qiniu-java-sdk-7.0.0.jar；gson-2.5.jar；okhttp-2.3.0-SNAPSHOT.jar；okio-1.3.0-SNAPSHOT.jar
 * @author Rex Zhang
 * @date 2016-1-19 下午05:40:46
 * @version V1.0
 * 
 */
public class QiniuUploadUtils {

	/**
	 * 上传
	 * 
	 * @param sourceFile
	 * @param newFileName
	 * @return
	 */
	public static boolean upload(String sourceFile, String newFileName) {
		return upload(sourceFile, newFileName, QinniuKongjian.woshipm);
	}

	/**
	 * 上传
	 * 
	 * @param sourceFile
	 * @param newFileName
	 * @return
	 */
	public static boolean upload(File sourceFile, String newFileName) {
		return upload(sourceFile, newFileName, QinniuKongjian.wenda);
	}

	/**
	 * 上传
	 * 
	 * @param sourceFile
	 * @param newFileName
	 * @return
	 */
	public static boolean upload(String sourceFile, String newFileName, QinniuKongjian kongjian) {
		boolean isSuccess = false;
		Auth authtest = Auth.create(OpenPlatAccounts.QINIU_AK, OpenPlatAccounts.QINIU_SK);
		UploadManager uploadManager = new UploadManager();
		try {
			String kongjianName = kongjian.name();
			if (kongjian == QinniuKongjian.qidianVip) {
				kongjianName = "qidian-vip";
			}
			Response res = uploadManager.put(sourceFile, newFileName, authtest.uploadToken(kongjianName));
			if (res.isOK()) {
				isSuccess = true;
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时简单状态信息
			// System.out.print(r.toString());
		}
		return isSuccess;
	}

	/**
	 * 上传
	 * 
	 * @param sourceFile
	 * @param newFileName
	 * @return
	 */
	public static boolean upload(File sourceFile, String newFileName, QinniuKongjian kongjian) {
		boolean isSuccess = false;
		Auth authtest = Auth.create(OpenPlatAccounts.QINIU_AK, OpenPlatAccounts.QINIU_SK);
		UploadManager uploadManager = new UploadManager();
		try {
			Response res = uploadManager.put(sourceFile, newFileName, authtest.uploadToken(kongjian.name()));
			if (res.isOK()) {
				isSuccess = true;
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时简单状态信息
			// System.out.print(r.toString());
		}
		return isSuccess;
	}
	
	/**
	 * 上传
	 * 
	 * @param sourceFile
	 * @param newFileName
	 * @return
	 */
	public static boolean uploadVip(File sourceFile, String newFileName, QinniuKongjian kongjian) {
	    boolean isSuccess = false;
	    Auth authtest = Auth.create(OpenPlatAccounts.QINIU_AK, OpenPlatAccounts.QINIU_SK);
	    UploadManager uploadManager = new UploadManager();
	    try {
            String kongjianName = kongjian.name();
            if (kongjian == QinniuKongjian.qidianVip) {
                kongjianName = "qidian-vip";
            }
            Response res = uploadManager.put(sourceFile, newFileName, authtest.uploadToken(kongjianName));
	        if (res.isOK()) {
	            isSuccess = true;
	        }
	    } catch (QiniuException e) {
	        Response r = e.response;
	        // 请求失败时简单状态信息
	        // System.out.print(r.toString());
	    }
	    return isSuccess;
	}

	public static void main(String[] args) {
		System.out.println("[upload]"
				+ upload("D://1530690575007_头像.jpg",
						"dd3333d.jpg"));
	}

	public static boolean upload(byte[] bytes, String fileName, QinniuKongjian kongjian) {
		boolean isSuccess = false;
		Auth authtest = Auth.create(OpenPlatAccounts.QINIU_AK, OpenPlatAccounts.QINIU_SK);
		UploadManager uploadManager = new UploadManager();
		try {
			String kongjianName = kongjian.name();
			if (kongjian == QinniuKongjian.qidianVip) {
				kongjianName = "qidian-vip";
			}
			Response res = uploadManager.put(bytes, fileName, authtest.uploadToken(kongjianName));
			if (res.isOK()) {
				isSuccess = true;
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时简单状态信息
			System.out.print(r.toString());
		}
		return isSuccess;
	}
}

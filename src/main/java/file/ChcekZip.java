/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipInputStream;

/**
 * 检验rar改名为zip后是否真的为zip
 *
 * @author 沈航冉
 * @date 2023-09-09 16:10:13
 */
public class ChcekZip {
	public static void main(String[] args) {
//		String zipFileName = "F:\\工作\\产品线正式工作\\sprint16\\值班\\Stage1\\附件1其实我是rar.zip";
		String zipFileName = "C:\\Users\\glodon\\Documents\\WXWork\\1688855604416026\\Cache\\File\\2023-10\\AAA.zip";
		try {
			ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(zipFileName)));
			if(isValidZipFile(zis)){
				System.out.println("这是zip文件");
			}else{
				System.out.println("这不是zip文件，有可能是rar改名为zip文件");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

//	private static boolean isValidZipFile(ZipInputStream zis) {
//		try {
//			// 读取ZIP文件的签名
//			byte[] signature = new byte[4];
//			int bytesRead = zis.read(signature);
//
//			// ZIP文件签名的前四个字节应该是 0x50 0x4B 0x03 0x04
//			return bytesRead == 4 && signature[0] == 0x50 && signature[1] == 0x4B && signature[2] == 0x03 && signature[3] == 0x04;
//		} catch (IOException e) {
//			// 发生IO异常时，也认为ZIP文件无效
//			return false;
//		}
//	}

	private static boolean isValidZipFile(ZipInputStream zis) {
		try {
			// 读取ZIP文件的签名
			byte[] signature = new byte[4];
			int bytesRead = 0;

			// 逐字节读取直到读取4个字节或达到流末尾
			while (bytesRead < 4) {
				int readByte = zis.read();
				signature[bytesRead] = (byte) readByte;
				bytesRead++;
			}

			// 检查读取的字节数和ZIP文件签名是否匹配
			return bytesRead == 4 && signature[0] == 0x50 && signature[1] == 0x4B && signature[2] == 0x03 && signature[3] == 0x04;
		} catch (IOException e) {
			// 发生IO异常时，也认为ZIP文件无效
			return false;
		}
	}
}
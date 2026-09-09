/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package file;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 类描述
 *
 * @author 沈航冉
 * @date 2023-09-09 16:20:25
 */
public class CheckZipFile {

	public static void main(String[] args) {
//		String filePath = "F:\\工作\\产品线正式工作\\sprint16\\值班\\Stage1\\附件1其实我是rar.zip"; // 要检查的文件路径
		String filePath = "C:\\Users\\glodon\\Documents\\WXWork\\1688855604416026\\Cache\\File\\2023-10\\Stage1(1).enc"; // 要检查的文件路径
		try {
			InputStream inputStream = new FileInputStream(filePath);
			boolean isZipFile = isZipFile(inputStream);
			if (isZipFile) {
				System.out.println(filePath + " ----是一个ZIP文件.");
			} else {
				System.out.println(filePath + " ----不是一个ZIP文件.");
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}


	}

	//	public static boolean isZipFile(InputStream is) {
//		try{
//			// 记录当前流的位置
////			is.mark(0);
//
//			byte[] magicBytes = new byte[2];
//			int bytesRead = is.read(magicBytes);
//
//			// 检查文件的前两个字节是否是"PK"，表示ZIP文件
//			boolean isZip = bytesRead == 2 && magicBytes[0] == 0x50 && magicBytes[1] == 0x4B;
//
//			// 恢复流的位置到之前记录的位置
////			is.reset();
//
//			return isZip;
//		} catch (IOException e) {
//			// 处理异常
//			e.printStackTrace();
//			return false;
//		}
//	}
	public static boolean isZipFile(InputStream is) {
		try {

			// 将 InputStream 输入流打包成 BufferedInputStream
			BufferedInputStream bfi = new BufferedInputStream(is);
			bfi.mark(Integer.MAX_VALUE);

			// 创建一个新的输入流，包装字节数组
			byte[] content = IOUtils.toByteArray(bfi);
			InputStream newInputStream = new ByteArrayInputStream(content);
			bfi.reset();

			// 读取前两个字节进行验证
			byte[] magicBytes = new byte[2];
			int bytesRead = bfi.read(magicBytes);

			// 检查文件的前两个字节是否是"PK"，表示ZIP文件
			boolean isZip = bytesRead == 2 && magicBytes[0] == 0x50 && magicBytes[1] == 0x4B;
			return isZip;
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

		// 使用新的输入流进行后续的操作

	}

}






package com.gg.springbootvuejs.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
	public static void zipFile(List<File> fileList, String zipPath) {
		File zipFile = new File(zipPath);
		ZipOutputStream out = null;
		if (!zipFile.exists()) {
			try {
				zipFile.createNewFile();
				out = new ZipOutputStream(new FileOutputStream(zipFile));
				int index = 0;
				InputStream is = null;
				for (File file : fileList) {
					is = new FileInputStream(file);
					out.putNextEntry(new ZipEntry(file.getAbsolutePath()));
					while ((index = is.read()) != -1) {
						out.write(index);
					}
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

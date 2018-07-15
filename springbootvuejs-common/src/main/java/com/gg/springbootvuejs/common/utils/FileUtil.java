package com.gg.springbootvuejs.common.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtil {
//	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * @param srcFilePath
	 *            源文件路径
	 * @param destFilePath
	 *            目标文件路径
	 * @return
	 */
	public static void copyFile(String srcFilePath, String destFilePath) {
		File srcFile = new File(srcFilePath);// 原文件
		File destFile = new File(destFilePath);// 新建文件
		if (!srcFile.isFile() || !srcFile.exists()) {
			return;
		}

		File directory = destFile.getParentFile();
		if (!directory.exists()) {
			directory.mkdirs();
		}

		try {
			destFile.createNewFile();
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			throw new RuntimeException(
					"com.self.common.utils.FileUtil.copy Failed, Exception:", e);
		}
	}

	/**
	 * 获取目标文件编码
	 * 
	 * @param file
	 *            待检测文件
	 * @return
	 */
	public static String getFileCharset(File file) {
		if (!file.isFile() || !file.exists()) {
			throw new RuntimeException(
					"com.self.common.utils.FileUtil.getCharset failed, file "
							+ file.getAbsolutePath()
							+ " is not file or not exist");
		}
		UniversalDetector detector = new UniversalDetector(null);
		try {
			@SuppressWarnings("resource")
			FileInputStream fis = new FileInputStream(file);
			byte[] buf = new byte[4096];
			int nread;
			while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
				detector.handleData(buf, 0, nread);
			}
			detector.dataEnd();
		} catch (Exception e) {
			throw new RuntimeException(
					"com.self.common.utils.FileUtil.getCharset failed, Exception:",
					e);
		}
		String encode = detector.getDetectedCharset();
		if (StringUtils.isEmpty(encode)) {
			throw new RuntimeException(
					"com.self.common.utils.FileUtil.getCharset failed");
		}
		detector.reset();
//		logger.debug("file " + file.getAbsolutePath() + "charset is:" + encode);
		return encode;
	}

	public static void main(String[] args) {
		System.out.println(getFileCharset(new File(
				"D:\\BaiduYunDownload\\btst_48_ace\\blank.html")));
	}
}

/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package docs;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SvgToPngConverter {

	public static void convertSvgToPng(String svgFilePath, String pngFilePath) throws Exception {
		// Create a PNG transcoder
		PNGTranscoder transcoder = new PNGTranscoder();

		// Input SVG
		InputStream inputStream = new FileInputStream(svgFilePath);
		TranscoderInput inputSvg = new TranscoderInput(inputStream);

		// Output PNG
		OutputStream outputStream = new FileOutputStream(pngFilePath);
		TranscoderOutput outputPng = new TranscoderOutput(outputStream);

		// Perform the conversion
		transcoder.transcode(inputSvg, outputPng);

		inputStream.close();
		outputStream.flush();
		outputStream.close();
	}

	public static void main(String[] args) {
		try {
			convertSvgToPng("C:/Users/glodon/Desktop/aaa.txt", "C:/Users/glodon/Desktop/aaa.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImageDecoding {

	public static void main(String[] args) {
		new ImageDecoding().run();
	}
	
	private void run() {
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
			PrintWriter pr = new PrintWriter(
				new BufferedWriter(
					new OutputStreamWriter(System.out)))) {
			int imgCount = 0;
			while (true) {
				List<Scanline> img = readInputImage(br);
				if (img.size() == 0) {
					break;
				} else {
					if (imgCount++ > 0) {
						pr.println();
					}
				}
				List<String> decodedImg = decode(img);
				writeOutputImg(decodedImg, pr);
			}
			br.close();
			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private List<Scanline> readInputImage(BufferedReader br) throws NumberFormatException, IOException {
		List<Scanline> scanlines = new ArrayList<>();
		int lineCount = Integer.parseInt(br.readLine());
		for (int lineIdx = 0; lineIdx < lineCount; lineIdx++) {
			String[] line = br.readLine().split(" ");
			Scanline scanline = new Scanline();
			scanline.firstChar = line[0].charAt(0);
			scanline.runs = 
				Arrays.stream(
						Arrays.copyOfRange(line, 1, line.length))
					  .map(s -> Integer.parseInt(s))
					  .collect(Collectors.toList());
			scanlines.add(scanline);
//			System.out.println(scanline.runs);
		}
//		System.out.println(scanlines.size());
		return scanlines;
	}
	
	private List<String> decode(List<Scanline> img) {
		List<String> decodedImg = new ArrayList<>();
		
		for (Scanline scanline : img) {
			StringBuilder decodedLine = new StringBuilder();
			char pixel = scanline.firstChar;
			for (int run : scanline.runs) {
				decodedLine.append(buildImgRun(pixel, run));
				pixel = nextPixel(pixel);
			}
			decodedImg.add(decodedLine.toString());
		}
		
//		System.out.println(decodedImg);
		return decodedImg;
	}

	private Map<Character, Map<Integer, String>> pixelRunSt = new HashMap<>();
	
	private String buildImgRun(char pixel, int run) {
		if (!pixelRunSt.containsKey(pixel)) {
			pixelRunSt.put(pixel, new HashMap<>());
		}
		Map<Integer, String> runSt = pixelRunSt.get(pixel);
		
		if (!runSt.containsKey(run)) {
			StringBuilder sbRun = new StringBuilder();
			for (int pIdx = 0; pIdx < run; pIdx++) {
				sbRun.append(pixel);
			}
			runSt.put(run, sbRun.toString());
		}
//		System.out.println(runSt.get(run));
		return runSt.get(run);
	}

	private char nextPixel(char pixel) {
		return pixel == '.' ? '#' : '.'; 
	}

	private void writeOutputImg(List<String> decodedImg, PrintWriter pr) {
		boolean error = false;
		for (String decodedLine: decodedImg) {
			pr.println(decodedLine);
			if (!error && decodedLine.length() != decodedImg.get(0).length()) {
				error = true;
			}
		}
		if (error) {
			pr.println("Error decoding image");
		}
	}

	class Scanline {
		char firstChar;
		List<Integer> runs = new ArrayList<>();
	}
}

package com.anhvurz90.algo.kattis;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Amsterdamdistance {

	private static DecimalFormat df2 = new DecimalFormat(".##############");
	
	public static void main(String[] args) {
		new Amsterdamdistance().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int segNum = sc.nextInt();
		int hringNum = sc.nextInt();
		double radius = sc.nextDouble();
		
		int ax = sc.nextInt();
		int ay = sc.nextInt();
		int bx = sc.nextInt();
		int by = sc.nextInt();
		
		double straitLength = radius * Math.abs(ay - by) / hringNum;
		
		double realRadius = radius * Math.min(ay, by) / hringNum;
		double curveLength = realRadius
							* Math.abs(ax - bx) / segNum * Math.PI;
		
		double minLength = straitLength + Math.min(curveLength, 2 * realRadius);
		System.out.println(
				Math.abs(minLength) < Math.pow(10, -7) ? 0 : df2.format(minLength));
		sc.close();
	}
}

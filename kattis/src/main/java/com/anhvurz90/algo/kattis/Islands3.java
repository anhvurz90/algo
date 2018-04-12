package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Islands3 {

	public static void main(String[] args) {
		new Islands3().run();
	}

	private void run() {
		char[][] map = readMap();
		List<List<Point>> parts = buildParts(map);
		
		int minIslandsCount = 
			parts.stream()
			 	.mapToInt(this::countMinIslands)
			 	.sum();
		
		System.out.println(minIslandsCount);
	}
	
	private char[][] readMap() {
		char[][] map = null; 
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			String[] src = br.readLine().split(" ");
			int row = Integer.parseInt(src[0]);
			int col = Integer.parseInt(src[1]);
			
			map = new char[row][col];
			for (int iRow = 0; iRow < row; iRow++) {
				String line = br.readLine();
				map[iRow] = line.toCharArray();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	private static char CLOUD = 'C';
	private static char LAND = 'L';
	private static char WATER = 'W';
	private static char VISITED = 'V';
	
	private List<List<Point>> buildParts(char[][] map) {
		List<List<Point>> parts = new ArrayList<>();
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				if (map[row][col] == CLOUD || map[row][col] == LAND) {
					parts.add(buildPart(map, row, col));
				}
			}
		}
		return parts;
	}

	private static final int[] xd = new int[] {0, 0, 1,-1};
	private static final int[] yd = new int[] {1,-1, 0, 0};
	
	private List<Point> buildPart(char[][] map, int row, int col) {
//		System.out.println(row + " " + col + " " + map.length + " " + map[0].length);
		List<Point> part = new ArrayList<>();
		Point p = new Point(row, col, map[row][col]);
		part.add(p);
		map[p.row][p.col] = VISITED;
		int currentPos = 0;
		while (currentPos < part.size()) {
			Point currentP = part.get(currentPos);
			int x = currentP.row;
			int y = currentP.col;
			
			for (int direct = 0; direct < 4; direct++) {
				int newX = x + xd[direct];
				int newY = y + yd[direct];
				if (okX(newX, map) && okY(newY, map) &&
					(map[newX][newY] == CLOUD || map[newX][newY] == LAND)) {
					Point newP = new Point(newX, newY, map[newX][newY]);
					part.add(newP);
					map[newX][newY] = VISITED;
				}
			}
			map[p.row][p.col] = VISITED; 
			currentPos ++;
		}
//		System.out.println(part);
		return part;
	}

	private boolean okX(int newX, char[][] map) {
		return newX >= 0 && newX < map.length;
	}

	private boolean okY(int newY, char[][] map) {
		return newY >= 0 && newY < map[0].length;
	}
	
	private int countMinIslands(List<Point> part) {
		char[][] map1 = buildMap(part, LAND);
		int count1 = buildParts(map1).size();
		
		char[][] map2 = buildMap(part, WATER);
		int count2 = buildParts(map2).size();
		
		return Math.min(count1, count2);
	}
	
	private char[][] buildMap(List<Point> part, char CLOUD_TO) {
		int maxRow = part.stream()
						 .map(p -> p.row)
						 .max(Integer::compare)
						 .get();
		int maxCol = part.stream()
						 .map(p -> p.col)
						 .max(Integer::compare)
						 .get();
		
//		System.out.println(part);
//		System.out.println(maxRow + " " + maxCol);
		char[][] map = new char[maxRow + 1][maxCol + 1];
		for (Point p : part) {
			char val = p.val == CLOUD ? CLOUD_TO : p.val;
			map[p.row][p.col]= val; 
		}
		
		return map;
	}

	class Point {
		int row;
		int col;
		char val;
		public Point(int row, int col, char val) {
			super();
			this.row = row;
			this.col = col;
			this.val = val;
		}
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", val=" + val + "]";
		}
		
	}
}

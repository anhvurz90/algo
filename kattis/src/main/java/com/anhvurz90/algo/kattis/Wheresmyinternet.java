package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Wheresmyinternet {

	public static void main(String[] args) {
		new Wheresmyinternet().run();
	}

	private void run() {
		List<Integer>[] map = readMap();
		int n = map.length;
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		int count = 0;
		while (!queue.isEmpty()) {
			int currentHouse = queue.poll();
			count ++;
			if (map[currentHouse] != null) {
				for (int neighbor : map[currentHouse]) {
					if (!visited[neighbor]) {
						queue.add(neighbor);
						visited[neighbor] = true;
					}
				}
			}
		}
		if (count == n-1) {
			System.out.println("Connected");
		} else {
			PrintWriter pr = new PrintWriter(
					new BufferedWriter(
						new OutputStreamWriter(System.out)));
			for (int h = 1; h < n; h++) {
				if (!visited[h]) {
					pr.println(h);
				}
			}
			pr.close();
		}
	}

	private List<Integer>[] readMap() {
		List<Integer>[] map = null;
		
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			String[] nm = br.readLine().split(" ");
			int houseCount = Integer.parseInt(nm[0]);
			int pairCount = Integer.parseInt(nm[1]);
			map = new List[houseCount + 1];
			
			for (int pIdx = 0; pIdx < pairCount; pIdx++) {
				String[] ab = br.readLine().split(" ");
				int a = Integer.parseInt(ab[0]);
				int b = Integer.parseInt(ab[1]);
				if (map[a] == null) {
					map[a] = new ArrayList<Integer>();
				}
				map[a].add(b);
				if (map[b] == null) {
					map[b] = new ArrayList<Integer>();
				}
				map[b].add(a);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
	}
}

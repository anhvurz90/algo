package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Horror {

	public static void main(String[] args) {
		new Horror().run();
	}

	private void run() {
		Graph graph = readGraph();
		int[] horrorVals = calculateHorrorVals(graph);
		int idxOfMaxHorror = 0;
		for (int idx = 0; idx < horrorVals.length; idx++) {
			if (horrorVals[idxOfMaxHorror] < horrorVals[idx]) {
				idxOfMaxHorror = idx;
			}
		}
		System.out.println(idxOfMaxHorror);
	}
	
	private Graph readGraph() {
		Graph graph = new Graph();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			String[] nhl = br.readLine().split(" ");
			graph.n = Integer.parseInt(nhl[0]);
			graph.horrors = 
				Arrays.stream(br.readLine().split(" "))
					  .map(s -> Integer.parseInt(s))
					  .collect(Collectors.toList());
			
			graph.neighbor = new List[graph.n];
			int pairs = Integer.parseInt(nhl[2]);
			for (int pairIdx = 0; pairIdx < pairs; pairIdx++) {
				String[] pair = br.readLine().split(" ");
				int a = Integer.parseInt(pair[0]);
				int b = Integer.parseInt(pair[1]);
				
				if (graph.neighbor[a] == null) {
					graph.neighbor[a] = new ArrayList<Integer>();
				}
				if (graph.neighbor[b] == null) {
					graph.neighbor[b] = new ArrayList<Integer>();
				}
				
				graph.neighbor[a].add(b);
				graph.neighbor[b].add(a);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return graph;
	}

	private static int MAX = (int)Math.pow(10, 6);
	private int[] calculateHorrorVals(Graph graph) {
		int[] horrorVals = new int[graph.n];
		boolean[] visited = new boolean[graph.n];
		Queue<Integer> queue = new LinkedList<>();
		
		Arrays.fill(horrorVals, MAX);
		for (int i : graph.horrors) {
			horrorVals[i] = 0;
			queue.add(i);
			visited[i] = true;
		}
		
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			if (graph.neighbor[vertex] != null) {
				for (int v : graph.neighbor[vertex]) {
					if (!visited[v]) {
						visited[v] = true;
						queue.add(v);
						horrorVals[v] = horrorVals[vertex] + 1;
					}
				}
			}
		}
		return horrorVals;
	}

	class Graph {
		int n;
		List<Integer> horrors = new ArrayList<>();
		List<Integer>[] neighbor;
	}
}

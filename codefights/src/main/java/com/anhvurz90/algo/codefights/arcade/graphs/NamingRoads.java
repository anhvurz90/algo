package com.anhvurz90.algo.codefights.arcade.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NamingRoads {

	boolean namingRoads(int[][] roads) {
		Map<Integer, Set<Integer>> vertices = new HashMap<>();
		for (int[] road : roads) {
			if (!vertices.containsKey(road[0])) {
				vertices.put(road[0], new HashSet<>());
			}
			if (!vertices.containsKey(road[1])) {
				vertices.put(road[1], new HashSet<>());
			}

			vertices.get(road[0]).add(road[2]);
			vertices.get(road[1]).add(road[2]);
		}

	}

}

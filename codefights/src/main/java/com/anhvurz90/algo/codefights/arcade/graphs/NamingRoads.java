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

			Set<Integer> set0 = vertices.get(road[0]);
			set0.add(road[2]);

			Set<Integer> set1 = vertices.get(road[1]);
			set1.add(road[2]);

			if (set0.contains(road[2] - 1) || set0.contains(road[2] + 1)) {
				return false;
			}

			if (set1.contains(road[2] - 1) || set1.contains(road[2] + 1)) {
				return false;
			}
		}

		return true;
	}

}

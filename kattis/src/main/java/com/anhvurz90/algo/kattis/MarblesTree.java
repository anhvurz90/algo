package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MarblesTree {

	public static void main(String[] args) {
		new MarblesTree().run();
	}
	
	private void run() {
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			Set<Vertex> tree = null;
			do {
				int moveCount = 0;
				tree = readTree(br);
	//			System.out.println(tree);
	//			System.out.println(tree.size());
				if (tree.size() > 0) {
					while (tree.size() > 1) {
						Vertex v = tree.iterator()
										.next();
						moveCount+= Math.abs(v.marbleCount - 1);
						
						Vertex parent = v.parent;
						if (parent != null) {
							tree.remove(parent);
							parent.marbleCount+= v.marbleCount - 1;
							parent.childCount--;
							tree.add(parent);
						}
						tree.remove(v);
	//					System.out.println(v);
	//					System.out.println(tree.size());
	//					System.out.println(tree);
					}
					
					System.out.println(moveCount);
				}
			} while (tree.size() > 0);
//			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Set<Vertex> readTree(BufferedReader br) throws IOException {
		Map<Integer, Vertex> treeMap = new HashMap<>();
		Set<Vertex> tree = new TreeSet<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int idx = 0; idx < n; idx++) {
			List<Integer> tokens =
					Arrays.stream(br.readLine().split(" "))
						  .map(s -> Integer.parseInt(s))
						  .collect(Collectors.toList());
			
			int name = tokens.get(0);
			int marbleCount = tokens.get(1);
			int childCount = tokens.get(2);
			
			Vertex v = treeMap.containsKey(name) ? 
						treeMap.get(name) : new Vertex();
			v.name = name;
			v.childCount = childCount;
			v.marbleCount = marbleCount;
			
			treeMap.put(name, v);
			tree.add(v);
			
			for (int childIdx = 0; childIdx < childCount; childIdx++) {
				int childName = tokens.get(childIdx + 3);
				Vertex child = treeMap.containsKey(childName) ? 
								treeMap.get(childName) : new Vertex();
				child.parent = v;
				treeMap.put(childName, child);
			}
//			System.out.println(v);
		}
//		System.out.println(treeMap);
		
		return tree;
	}

	class Vertex implements Comparable<Vertex> {

		int name;
		int childCount;
		int marbleCount;
		Vertex parent;
		
		public Vertex() {
			super();
		}
		
		public Vertex(int name, int childCount, int marbleCount, 
					  int moveCount, Vertex parent) {
			super();
			this.name = name;
			this.childCount = childCount;
			this.marbleCount = marbleCount;
			this.parent = parent;
		}

		@Override
		public int compareTo(Vertex v) {
			return this.childCount != v.childCount ? 
					this.childCount - v.childCount :
					this.name - v.name ;
		}
		
		@Override
		public int hashCode() {
			return Integer.hashCode(this.name);
		}
		
		@Override
		public boolean equals(Object o) {
			return (o instanceof Vertex) &&
				   (this.name == ((Vertex)o).name);
		}

		@Override
		public String toString() {
			return "Vertex [name=" + name + ", childCount=" + childCount + ", marbleCount=" + marbleCount + ", parent="
					+ (parent == null ? "null" : parent.name) + "]";
		}
		
	}
}

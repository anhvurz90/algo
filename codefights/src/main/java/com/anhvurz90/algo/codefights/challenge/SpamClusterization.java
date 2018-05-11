package com.anhvurz90.algo.codefights.challenge;

public class SpamClusterization {

	int[][] spamClusterization(String[] requests, int[] ids, double threshold) {
		int len = requests.length;
		java.util.List<java.util.Set<String>> sets = new java.util.ArrayList<>();
		for (String req : requests) {
			sets.add(toSet(req));
			System.out.println(toSet(req));
		}

		boolean[][] same = new boolean[len][len];
		for (int o = 0; o < len; o++) {
			for (int i = 0; i < len; i++) {
				java.util.Set<String> s1 = new java.util.HashSet<String>(sets.get(o));
				java.util.Set<String> s2 = new java.util.HashSet<String>(sets.get(o));
				s1.retainAll(sets.get(i));
				s2.addAll(sets.get(i));
				System.out.println(o + " " + i + " " + s1.size() * 1.0 / s2.size());
				if (s1.size() * 1.0 / s2.size() >= threshold) {
					same[o][i] = true;
				}
			}
		}

		boolean[] flag = new boolean[len];

		int count = 0;
		java.util.List<java.util.List<Integer>> rr = new java.util.ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (!flag[i]) {
				int[] ret = spread(flag, same, i);
				if (ret.length > 1) {
					java.util.List<Integer> idRet = buildIdRet(ret, ids);
					java.util.Collections.sort(idRet);
					rr.add(idRet);
				}
			}
		}

		java.util.Collections.sort(rr, new ListComparator());

		int[][] r2 = new int[rr.size()][];
		int cc = 0;
		for (java.util.List<Integer> l : rr) {
			r2[cc++] = toArray(l);
		}

		return r2;
	}

	private int[] toArray(java.util.List<Integer> l) {
		int[] ret = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			ret[i] = l.get(i);
		}
		return ret;
	}

	private java.util.List<Integer> buildIdRet(int[] ret, int[] ids) {
		java.util.List<Integer> r = new java.util.ArrayList<>();
		for (int i : ret) {
			r.add(ids[i]);
		}
		return r;
	}

	private int[] spread(boolean[] flag, boolean[][] same, int i) {
		java.util.List<Integer> ret = new java.util.ArrayList<>();
		spread(flag, same, i, ret);
		return toArray(ret);
	}

	private void spread(boolean[] flag, boolean[][] same, int i, java.util.List<Integer> ret) {
		ret.add(i);
		flag[i] = true;
		for (int k = 0; k < flag.length; k++) {
			if (!flag[k] && same[i][k]) {
				spread(flag, same, k, ret);
			}
		}
	}

	private java.util.Set<String> toSet(String req) {
		java.util.Set<String> ret = new java.util.HashSet<String>();

		String st = "";
		for (int i = 0; i < req.length(); i++) {
			char c = req.charAt(i);
			if (Character.isLetter(c)) {
				st += Character.toLowerCase(c);
			} else {
				if (st.length() > 0) {
					ret.add(st);
				}
				st = "";
			}
		}
		return ret;
	}

	class ListComparator implements java.util.Comparator<java.util.List<Integer>> {

		@Override
		public int compare(java.util.List<Integer> o1, java.util.List<Integer> o2) {
			int m1 = findMin(o1);
			int m2 = findMin(o2);
			return m1 - m2;
		}

		int findMin(java.util.List<Integer> l) {
			int m = l.get(0);
			for (int i : l) {
				m = Math.min(i, m);
			}
			return m;
		}

	}

}

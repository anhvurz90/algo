package com.anhvurz90.algo.kattis;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Milestones {

    public static void main(String[] args) {
        new Milestones().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        long[] times = new long[m];
        for (int i = 0; i < m; i++) {
            times[i] = sc.nextLong();
        }
        long[] dis = new long[n];
        for (int i = 0; i < n; i++) {
            dis[i] = sc.nextLong();
        }
        
        Set<Long> ret = new TreeSet<>();
        for (int iDis = 0; iDis < n - m + 1; iDis++) {
            if (ok(times, dis, iDis)) {
                ret.add(dis[iDis+1] - dis[iDis]);
            }
        }
        
        System.out.println(ret.size());
        if (!ret.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Long r: ret) {
                sb.append(r).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
        sc.close();
    }
    
    private boolean ok(long[] times, long[] dis, int disIdx) {
        double ratio = 1.0 * (times[1] - times[0]) / (dis[disIdx + 1] - dis[disIdx]);
        for (int i = 0; i < times.length-1; i++) {
            double r1 = 1.0 * (times[i + 1] - times[i]) / (dis[disIdx + 1 + i] - dis[disIdx + i]);
            if (Math.abs(ratio - r1) > Math.pow(10, -8)) {
                return false;
            }
        }
        return true;
    }
}

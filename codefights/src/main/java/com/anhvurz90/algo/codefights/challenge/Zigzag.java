package com.anhvurz90.algo.codefights.challenge;

public class Zigzag {

  int zigzag(int[] a) {
    int max = 1;
    int len = a.length;
    for (int start = 0; start < len; start++) {
        for (int end = start; end < len; end++) {
            boolean ok = true;
            for (int i = start + 1; i < end - 1; i++) {
                ok = ok & 
                    (a[i] > a[i-1] && a[i] > a[i+1] ||
                     a[i] < a[i-1] && a[i] < a[i+1]);
            }
            if (ok) {
                max = Math.max(max, end - start);
            }
        }
    }
    return max;
  }

}

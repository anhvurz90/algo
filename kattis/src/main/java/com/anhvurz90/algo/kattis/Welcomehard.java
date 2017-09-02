package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Welcomehard {
    public static void main(String[] args) {
        new Welcomehard().run();
    }
    
    int n;
    String welcome = "welcome to code jam";

    private void run() {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i <n; i++) {
            String st = sc.nextLine();
            int[][] count = new int[welcome.length()][st.length()];
//                    [[0 for x in range(len(st))] for y in range(len(welcome))]
//        #    print(len(count), len(count[0])); 
//            #print(i, st, count);
            for (int index= 0; index < st.length(); index++) {
                if (st.charAt(index) == 'w')
                    count[0][index] = 1;
            }
            
            for (int idx_w=1; idx_w < welcome.length(); idx_w++) {
                for (int idx_st=0; idx_st < st.length(); idx_st++) {
                    if (st.charAt(idx_st) == welcome.charAt(idx_w)) {
                        for (int idx2_st = 0; idx2_st < idx_st; idx2_st++) {
                            if (st.charAt(idx2_st) == welcome.charAt(idx_w-1)) {
//        #                        print(idx_w);
                                count[idx_w][idx_st] += count[idx_w-1][idx2_st];
                                count[idx_w][idx_st] %= 10000;
//        #                        print(count[idx_w]);
                            }
                        }
                    }
                }
//        #     for r in range(len(count)):
//        #         print(r, count[r]);
            }
            System.out.println("Case #" + (i+1) + ": " + fullLength(String.valueOf(sum(count[welcome.length() - 1]))));
        }
        
        sc.close();
    }
    
    private int sum(int[] is) {
        int ret = 0;
        for (int i : is) {
            ret += i;
        }
        return ret %= 10000;
    }

    private String fullLength(String st) {
        String ret = st;
        while (ret.length() < 4) {
            ret = "0" + ret;
        }
        return ret;
    }
    
}



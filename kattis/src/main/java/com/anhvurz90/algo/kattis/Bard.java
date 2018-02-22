package com.anhvurz90.algo.kattis;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bard {
    
    public static void main(String[] args) {
        new Bard().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer>[] songsOfV = new Set[n];
        for (int i = 0; i < n; i++) {
            songsOfV[i] = new HashSet<>();
        }
        
        int e = sc.nextInt();
        int newSongId = 0;
        for (int i = 0; i < e; i++) {
            boolean newSong = false;
            int k = sc.nextInt();
            int[] villagers = new int[k];
            for (int iV = 0; iV < k; iV++) {
                villagers[iV] = sc.nextInt() - 1;
                if (villagers[iV] == 0) {
                    newSong = true;
                }
            }
            if (newSong) {
                newSongId++;
                for (int iV = 0; iV < k; iV++) {
                    if (villagers[iV] != 0) {
                        songsOfV[villagers[iV]].add(newSongId);
                    }
                }
            } else {
                Set<Integer> totalSongs = new HashSet<>();
                for (int iV = 0; iV < k; iV++) {
                    totalSongs.addAll(songsOfV[villagers[iV]]);
                }
                for (int iV = 0; iV < k; iV++) {
                    songsOfV[villagers[iV]] = new HashSet<>(totalSongs);
                }
            }
            
//            for (int iV = 1; iV < n; iV++) {
//                System.out.println(songsOfV[iV]);
//            }
//            System.out.println("---");
            
        }
        
        System.out.println(1);
        for (int i = 1; i < n; i++) {
            if (songsOfV[i].size() == newSongId) {
                System.out.println(i + 1);
            }
        }
        sc.close();
    }
}

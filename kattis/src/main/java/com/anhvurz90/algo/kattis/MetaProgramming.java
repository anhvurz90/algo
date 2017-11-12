package com.anhvurz90.algo.kattis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MetaProgramming {

    public static void main(String[] args) throws IOException {
        new MetaProgramming().run();
    }
    
    private Map<String, Integer> map = new HashMap<>();
    private void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            String[] elems = line.split("\\s+");
            if (elems[0].equals("define")) {
                map.put(elems[2], Integer.parseInt(elems[1]));
            } else if (elems[0].equals("eval")) {
                Integer val1 = map.get(elems[1]);
                Integer val2 = map.get(elems[3]);
                if (val1 == null || val2 == null) {
                    System.out.println("undefined");
                } else {
                    switch (elems[2]) {
                        case "<":
                            System.out.println(val1 < val2);
                            break;
                        case ">":
                            System.out.println(val1 > val2);
                            break;
                        case "=":
                            System.out.println(val1 == val2);
                            break;
                    }
                }
            }
        }
        sc.close();
    }
}

/*
ID: anhvurz1
LANG: JAVA
TASK: ride
*/

package com.anhvurz90.algo.usaco.sec1_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {

    public static void main(String[] args) throws IOException {
        new ride().solveTask();
    }

    public void solveTask() throws IOException {
        final String contextPath = "";// "src/main/resources/";
        BufferedReader in = new BufferedReader(
                                new FileReader(contextPath + "ride.in"));
        PrintWriter out = new PrintWriter(
                            new BufferedWriter(
                               new FileWriter(contextPath + "ride.out")));

        final String ret = productMod47(in.readLine()) == productMod47(in.readLine()) ? "GO" : "STAY";
        out.println(ret);

        in.close();
        out.close();
    }

    private int productMod47(final String st) {
        int ret = 1;
        for (final char c : st.toCharArray()) {
            ret = ret * (c - 'A' + 1) % 47;
        }
        return ret;
    }
}

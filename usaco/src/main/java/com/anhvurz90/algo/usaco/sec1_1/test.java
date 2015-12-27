/*
ID: anhvurz1
LANG: JAVA
TASK: test
*/

package com.anhvurz90.algo.usaco.sec1_1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) throws IOException {
        new test().solveTask();
    }

    public void solveTask() throws IOException {
        final String contextPath = "";// "src/main/resources/";
        BufferedReader br = new BufferedReader(new FileReader(contextPath + "test.in"));
        PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(contextPath + "test.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        pr.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        pr.close();
        br.close();
    }
}

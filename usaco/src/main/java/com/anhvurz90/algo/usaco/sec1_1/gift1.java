/*
ID: anhvurz1
LANG: JAVA
TASK: gift1
*/

package com.anhvurz90.algo.usaco.sec1_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class gift1 {

    public static void main(String[] args) throws IOException {
        new gift1().solveTask();
    }

    public void solveTask() throws IOException {
        final String contextPath = "";// "src/main/resources/";
        BufferedReader in = new BufferedReader(
                                new FileReader(contextPath + "gift1.in"));
        PrintWriter out = new PrintWriter(
                                new BufferedWriter(
                                        new FileWriter(contextPath + "gift1.out")));
        // -------------- input + processing
        final int np = Integer.parseInt(in.readLine());
        
        final Set<String> members = new LinkedHashSet<String>();
        final Map<String, Integer> memberMoney = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < np; i++) {
            final String mem = in.readLine();
            members.add(mem);
            memberMoney.put(mem, 0);
        }
        do {
            final String mem = in.readLine();
            if (mem == null) {
                break;
            }
            // System.out.println(mem);
            final String[] initialMoneyPeopleNum = in.readLine().split(" ");
            // System.out.println(initialMoneyPeopleNum[0] + " " + initialMoneyPeopleNum[1]);
            final int initialMoney = Integer.parseInt(initialMoneyPeopleNum[0]);
            final int peopleNum = Integer.parseInt(initialMoneyPeopleNum[1]);
            if (peopleNum != 0) {
                memberMoney.put(mem, memberMoney.get(mem) - initialMoney);
                memberMoney.put(mem, memberMoney.get(mem) + initialMoney % peopleNum);
                for (int i = 0; i < peopleNum; i++) {
                    final String givenMember = in.readLine();
                    memberMoney.put(givenMember, memberMoney.get(givenMember) + initialMoney / peopleNum);
                }
            }
        } while (true);
        // -------------- output
        for (final String member : members) {
            out.printf("%s %d\n", member, memberMoney.get(member));
        }
        in.close();
        out.close();
    }

}

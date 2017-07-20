'''
Created on Jul 20, 2017

@author: anhvu
'''
from _functools import reduce
n = 1;
while n != -1:
    n = int(input());
    if n == -1:
        break;
    
    weeks = [1] * n;
    graph = [];
    for r in range(n):
        row = input().split();
        graph.append(row);
        
    for r in range(n):
        for c in range(n):
            if (r != c) & (graph[r][c] == "1"):
                for k in range (n):
                    if (k != r) & (k != c) & ((graph[r][k] == "1") & (graph[k][c] == "1")):
                        weeks[r] = 0;
                        weeks[c] = 0;
                        weeks[k] = 0;
    
    ret = [index for index, val in enumerate(weeks) if val==1];

    print(reduce(lambda x, y: str(x) + " " + str(y), ret, ""));
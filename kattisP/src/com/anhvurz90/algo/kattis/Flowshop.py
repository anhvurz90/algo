'''
Created on Oct 1, 2017

@author: anhvu
'''
from _functools import reduce
pair = [int(i) for i in input().split()];

n = pair[0];
m = pair[1];

cost0 = [0 for i in range(m)];
total = [];

for swather in range(n):
    cost1 = [0 for i in range(m)];
    stages = [int(i) for i in input().split()];
    for stageIndex in range(m):
        if (stageIndex == 0):
            cost1[stageIndex] = cost0[stageIndex] + stages[stageIndex];
        else:
            cost1[stageIndex] = max(cost0[stageIndex], cost1[stageIndex - 1]) + stages[stageIndex];
#     print(cost1);
    total.append(cost1[m - 1]);
    cost0 = cost1;

print(reduce(lambda x, y: str(x) + " " + str(y), total));
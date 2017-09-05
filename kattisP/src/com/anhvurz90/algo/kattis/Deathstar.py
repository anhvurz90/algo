'''
Created on Sep 5, 2017

@author: anhvu
'''
from _functools import reduce

n = int(input());
ret = [];
for r in range(n):
    val = 0;
    row = [int(i) for i in input().split()];
    for v in row:
        val |= v;
    ret.append(val);
print(reduce((lambda x, y: str(x) + " " + str(y)), ret));
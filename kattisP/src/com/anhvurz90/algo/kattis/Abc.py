'''
Created on Sep 5, 2017

@author: anhvu
'''
from _functools import reduce

triple = [int(i) for i in input().split()];
triple.sort();
m = {};
m['A']= triple[0];
m['B']= triple[1];
m['C']= triple[2];

ret = [];
for c in input():
    ret.append(m[c]);

print(reduce(lambda x, y: str(x) + " " + str(y), ret));

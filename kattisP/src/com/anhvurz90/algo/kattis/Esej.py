'''
Created on Oct 27, 2017

@author: anhvu
'''
from math import ceil
from _functools import reduce
[a, b] = [int(i) for i in input().split()];
c = 0;
if (a == b):
    c = a;
else:
    c = max(a, ceil(b/2));
count = 0;
s1 = [""];
while (count < c):
    count = 0;
    s2 = [];
    for s in s1:
        for char in range(ord('a'), ord('z') + 1):
            s2.append(s + chr(char));
            count+= 1;
            if count >= c:
                break;
        if count >= c:
            break;
    s1 = s2;
print(reduce(lambda x, y: x + " " + y, s1));
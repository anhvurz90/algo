'''
Created on Jul 20, 2017

@author: anhvu
'''
from math import floor
def digitSum(x : int):
    s = 0;
    while (x > 0):
        s += (x % 10);
        x = floor(x / 10);
    return s;

l = int(input());
d = int(input());
x = int(input());

mi = d;
ma = l;
for i in range(l, d+1):
    if (digitSum(i) == x):
        mi = min(mi, i);
        ma = max(ma, i);
       
print(mi, ma); 

'''
Created on Sep 12, 2017

@author: anhvu
'''
from math import sin, cos
global p, a, b, c, d;

def price(k):
    global p, a, b, c, d;
    return p * (sin(a * k + b) + cos(c * k + d) + 2);

si = [int(i) for i in input().split()];
p = si[0];
a = si[1];
b = si[2];
c = si[3];
d = si[4];
n = si[5];

mi = price(1);
ma = price(1);

ret = 0;
for i in range(1, n):
    current = price(i + 1);
    if (ma - current > ret):
        ret = ma - current;
    mi = min(mi, current);
    ma = max(ma, current);
    
print(ret);

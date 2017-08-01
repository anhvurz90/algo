'''
Created on Aug 1, 2017

@author: anhvu
'''
from math import floor, sqrt

mesg = input();
n = len(mesg);

r = 1;
for i in range(1, floor(sqrt(n)) + 1):
    c = n // i;
    if (c * i == n):
        r = i;

c = n // r;
m = [['x' for i in range(c)] for j in range (r)];

for i in range(n):
    row_ = i % r;
    col_ = i // r;
    m[row_][col_] = mesg[i];
    
print(''.join(''.join(c for c in row_) for row_ in m));
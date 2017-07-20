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

n = 1;
while (n > 0):
    n = int(input());
    if (n > 0):
        p = 11;
        while (digitSum(n) != digitSum(n * p)):
            p+= 1;
        print(p);
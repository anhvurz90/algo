'''
Created on Jul 22, 2017

@author: anhvu
'''

vals = [int(i) for i in input().split()];
x = vals[0];
y = vals[1];

if (x == 0) & (y==1):
    print("ALL GOOD");
elif (y == 1):
    print("IMPOSSIBLE");
else:
    print(x / (1 - y));

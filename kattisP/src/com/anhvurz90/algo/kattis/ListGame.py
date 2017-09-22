'''
Created on Sep 22, 2017

@author: anhvu
'''
from math import sqrt

x = int(input());
count = 0;

l = int(sqrt(x)) + 2;
for i in range(2, l):
#    print(i);
    if (x == 1):
        break;
    if (x >= i):
        while (x % i == 0):
            count+= 1;
            x//= i;
#            print(" " + str(x))
if (x > 1):
    print(count + 1);
else:
    print(count);
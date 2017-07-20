'''
Created on Jul 20, 2017

@author: anhvu
'''
from math import sqrt
triple = [int(i) for i in input().split(" ")];
n = triple[0];
w = triple[1];
h = triple[2];
diagonal = sqrt(w * w + h * h);
for j in range(n):
    l = int(input());
#    print(j, ":", n, ":", l);
    if (l <= diagonal):
        print("DA");
    else:
        print("NE");
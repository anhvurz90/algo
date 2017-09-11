'''
Created on Sep 11, 2017

@author: anhvu
'''
pair = [int(i) for i in input().split()];
r = pair[0];
c = pair[1];
print(100 * (r-c)*(r-c)/r/r);